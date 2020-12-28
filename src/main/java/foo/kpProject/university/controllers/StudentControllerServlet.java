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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        listStudents(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentDbUtil.getStudents();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-students.jsp");
        requestDispatcher.forward(request, response);
    }
}
