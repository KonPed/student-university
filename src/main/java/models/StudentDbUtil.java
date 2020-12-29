package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    public StudentDbUtil() {
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM web_student_tracker.student ORDER BY last_name";
        try(
                Statement statement = dbConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                Student student = new Student(id, firstName, lastName, email);
                students.add(student);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student student) {
        String sql = "insert into web_student_tracker.student (first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = dbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public Student getStudentById(int studentId) {
        Student loadedStudent = null;
        String sql = "select * from web_student_tracker.student where id = ?";
        try (PreparedStatement preparedStatement = dbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int loadedStudentId = result.getInt("id");;
                String loadedStudentFirstName = result.getString("first_name");
                String loadedStudentLastName = result.getString("last_name");
                String loadedStudentEmail = result.getString("email");
                loadedStudent = new Student(loadedStudentId, loadedStudentFirstName, loadedStudentLastName, loadedStudentEmail);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return loadedStudent;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE web_student_tracker.student SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = dbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public Connection dbConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/web_student_tracker", "root", "deko");
    }
}
