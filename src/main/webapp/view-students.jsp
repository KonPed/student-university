<%@ page import="java.util.List, models.Student" %>

<jsp:include page="layout/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<div class="row">
    <div class="col-6">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${STUDENT_LIST}">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>@${student.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

<jsp:include page="layout/footer.jsp" />