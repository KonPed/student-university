<%@ page import="java.util.List, models.Student" %>

<jsp:include page="layout/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-6">
            <div class="button_separator">
                <a type="button" class="btn btn-warning" href="student-form.jsp">
                    <span style="color: orangered;">
                        <i class="fas fa-plus fa-lg fa-fw"></i>
                    </span>Add Student
                </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${STUDENT_LIST}">
                    <c:url var="tempLink" value="StudentControllerServlet">
                        <c:param name="command" value="LOAD" />
                        <c:param name="studentId" value="${student.id}" />
                    </c:url>
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>@${student.email}</td>
                        <td><a href="${tempLink}">Update</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <a href="index.jsp">Go back</a>
        </div>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>