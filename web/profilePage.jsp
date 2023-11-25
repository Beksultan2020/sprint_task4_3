<%@ page import="db.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>

<%
    User user = (User) request.getSession().getAttribute("user");
    if (user != null) {
%>
<div class="container mt-3">
    <form action="/profilePageUser" method="post">
    <div class="mb-3">
        <label class="form-label">FullName</label>
        <input type="text" class="form-control" name="full_name" value="<%=user.getFull_name()%>">
    </div>
    <div class="mb-3">
        <label  class="form-label">Password</label>
        <input type="text" class="form-control" name="password" value="<%=user.getPassword()%>">
    </div>
    <div class="mb-3">
        <label  class="form-label">Repeat Password</label>
        <input type="text" class="form-control" name="repeatpass" value="<%=user.getPassword()%>">
    </div>
    <div class="mb-3">
        <button type="submit" class="btn btn-success">UPDATE</button>
    </div>
    </form>
</div>
<%
    }
%>
</body>
</html>
