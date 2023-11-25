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
import java.util.List;

@WebServlet(value = "/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News> news= DBManager.getAllNews();
        req.setAttribute("novosti",news);
        req.getRequestDispatcher("main.jsp").forward(req,resp);
        resp.sendRedirect("/news");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("news_title");
        String content=req.getParameter("news_content");
        User user = (User) req.getSession().getAttribute("user");
        News news=new News(title,content,user);
        DBManager.addNews(news);
        resp.sendRedirect("/news");
    }
}
