<jsp:include page="layout/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="row align-items-start">
            <div class="col-md-6 offset-md-3">
                <h3>Register Student</h3>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingFirstName" name="first_name"
                           placeholder="name@example.com">
                    <label for="floatingFirstName">First Name</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingLastName" name="last_name"
                           placeholder="Password">
                    <label for="floatingLastName">Last Name</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="floatingEmail" name="email" placeholder="Password">
                    <label for="floatingEmail">Email</label>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>

