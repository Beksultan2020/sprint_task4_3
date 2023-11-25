package Servlets;

import db.DBManager;
import db.News;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/news_update")
public class NewsUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long newsId=Long.parseLong(req.getParameter("news_id"));
        String title=req.getParameter("news_title");
        String content =req.getParameter("news_content");
        User user= (User) req.getSession().getAttribute("user");
        News news=DBManager.getNewsById(newsId);
        news.setTitle(title);
        news.setContent(content);
        news.setUser(user);
        DBManager.newsUpdate(news);
        resp.sendRedirect("/news");
    }
}
