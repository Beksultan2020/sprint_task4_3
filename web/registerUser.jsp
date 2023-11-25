<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container mt-3">
    <div class="row">
        <div class="col">
            <form method="post" action="/registerUser">
                <div class="mb-3">
                    <label class="form-label">FullName</label>
                    <input type="text" class="form-control" name="full_name">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Email</label>
                    <input type="text" class="form-control" name="email">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Password</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Repeat Password</label>
                    <input type="password" class="form-control" name="repeatpass">
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-success">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
