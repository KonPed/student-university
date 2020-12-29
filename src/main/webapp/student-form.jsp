<jsp:include page="layout/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="row align-items-start">
            <div class="col-md-6 offset-md-3">
                <h3>Register Student</h3>
                <form action="StudentControllerServlet" method="get">
                    <div class="form-floating mb-3 visually-hidden">
                        <input type="text" class="form-control" id="hiddenCommand" name="command" value="ADD">
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingFirstName" name="first_name" value="${requestScope.first_name}"
                               placeholder="first_name">
                        <label for="floatingFirstName">First Name</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingLastName" name="last_name" value="${requestScope.last_name}"
                               placeholder="last_name">
                        <label for="floatingLastName">Last Name</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingEmail" name="email" value="${requestScope.email}"
                               placeholder="email">
                        <label for="floatingEmail">Email</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
            <div class="col-6">
                <a href="index.jsp">Go Back</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>

