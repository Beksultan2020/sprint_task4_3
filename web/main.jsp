<%@ page import="java.util.ArrayList" %>
<%@ page import="db.News" %>
<%@ page import="java.util.List" %>
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
    if (user != null && user.getRole_id() == 1) {
%>
<div class="container mt-3">
    <button type="button" class="btn btn-success" data-bs-toggle="modal"
            data-bs-target="#exampleModal">Add News
    </button>
</div>
<%
    }
%>
<!-- Modal -->
<form action="/news" method="post">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Add News</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Title</label>
                        <input type="text" class="form-control" placeholder="Name:" name="news_title">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Content:</label>
                        <input type="text" class="form-control" placeholder="Surname:" name="news_content">
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success">Add News</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>TITLE</th>
            <th>POST DATE</th>
            <th>DETAILS</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<News> news = (List<News>) request.getAttribute("novosti");
            for (News news1 : news) {
        %>
        <tr>
            <td><%=news1.getId()%>
            </td>
            <td><%=news1.getTitle()%>
            </td>
            <td><%=news1.getPostDate()%>
            </td>
            <td><a href="/news_details?id=<%=news1.getId()%>" type="button" class="btn btn-success">Details</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>