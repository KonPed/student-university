package foo.kpProject.university;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet(name = "testServlet", value = "/TestServlet")

public class TestServlet extends HttpServlet {
    String sql = "SELECT * FROM student";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/web_student_tracker", "root", "deko");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ) {
            printWriter.println("<html><body>");
            while (resultSet.next()) {
                printWriter.println("<p>" + resultSet.getString("first_name") + "</p>");
            }
            printWriter.println("</body></html>");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
