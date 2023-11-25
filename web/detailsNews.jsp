<%@ page import="java.util.ArrayList" %>
<%@ page import="db.News" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>
<%
    News news = (News) request.getAttribute("news");
    if (news != null) {
%>

<div class="container mt-3">
    <form action="/news_update" method="post">
        <div class="mb-3">
            <label class="form-label">ID</label>
            <input type="text" class="form-control"  name="news_id" value="<%=news.getId()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input type="text" class="form-control" name="news_title" value="<%=news.getTitle()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input type="text" class="form-control"  name="news_content" value="<%=news.getContent()%>">
        </div>
        <p>Posted by <b><%=news.getUser().getFull_name()%></b> at <%=news.getPostDate()%></p>
        <div class="mb-3">
            <button class="btn btn-success">
                UPDATE NEWS
            </button>
        </div>
    </form>

    <form action="/deleteNews" method="post">
        <input type="hidden" class="form-control" name="id" value="<%=news.getId()%>">
        <div class="mb-3">
            <button class="btn btn-danger">
                Delete
            </button>
        </div>
    </form>
</div>
<%
    }
%>
</body>
</html>