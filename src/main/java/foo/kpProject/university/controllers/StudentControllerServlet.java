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
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
                    listStudents(request, response);
                    break;
                case "ADD" :
                    addStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentDbUtil.getStudents();
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-students.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        studentDbUtil.addStudent(new Student(firstName, lastName, email));
        listStudents(request, response);
    }
}
