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
            Map<String, String[]> parameterMap = request.getParameterMap();
            for (String[] params : parameterMap.values()) {
                if (Arrays.asList(params).contains("ADD")) {
                    /* TODO: handle add student operation (save a new student to database.) */
                    System.out.println("Requested to add student.");
                    break;
                }
            }
            if (parameterMap.values().contains("ADD")) {
                System.out.println("Requested to add student.");
            }
            listStudents(request, response);
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

    private void addStudent(Student student) {

    }
}
