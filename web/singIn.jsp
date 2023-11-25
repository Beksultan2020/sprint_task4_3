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
            <form method="post" action="/signInUser">
                <div class="mb-3">
                    <label  class="form-label">Email</label>
                    <input type="text" class="form-control" name="email">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Password</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-success">Sing In</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
