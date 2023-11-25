<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>
<body>
<div class="container">
    <div class="row mt-md-3">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg" style="background-color: #198754" >
                <div class="container-fluid">
                    <a class="navbar-brand" href="http://localhost:8080/news">News Manager</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/news">All News</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/signInUser">Sign In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/registerUser">Register In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/signInUser">Log out</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/profilePageUser">Profile Page</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
