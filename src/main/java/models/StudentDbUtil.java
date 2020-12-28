package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    public StudentDbUtil() {
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY last_name";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/web_student_tracker", "root", "deko");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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
}
