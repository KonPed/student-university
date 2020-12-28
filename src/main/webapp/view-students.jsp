<jsp:include page="layout/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
<div class="row">
    <div class="col-6">
        <c:forEach var="student" items="${STUDENT_LIST}">
            <p>${student}</p>
        </c:forEach>
    </div>
</div>
</div>

<jsp:include page="layout/footer.jsp" />