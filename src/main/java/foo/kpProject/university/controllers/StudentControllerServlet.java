package foo.kpProject.university.controllers;

import models.Student;
import models.StudentDbUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
    private StudentDbUtil studentDbUtil;

    @Override
    public void init() throws ServletException {
        studentDbUtil = new StudentDbUtil();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "LIST";
            }
            switch (command) {
                case "LIST":
                    onListStudents(request, response);
                    break;
                case "ADD" :
                    onAddStudent(request, response);
                    break;
                case "LOAD" :
                    onLoadStudent(request, response);
                    break;
                case "UPDATE" :
                    onUpdateStudent(request, response);
                    break;
                default:
                    onListStudents(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void onListStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentDbUtil.getStudents();
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-students.jsp");
        requestDispatcher.forward(request, response);
    }

    private void onAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        studentDbUtil.addStudent(new Student(firstName, lastName, email));
        onListStudents(request, response);
    }

    private void onLoadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        Student loadedStudent = studentDbUtil.getStudentById(studentId);
        request.setAttribute("THE_STUDENT", loadedStudent);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-student-form.jsp");
        requestDispatcher.forward(request, response);
    }

    private void onUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        studentDbUtil.updateStudent(new Student(studentId, firstName, lastName, email));
        onListStudents(request, response);
    }
}
