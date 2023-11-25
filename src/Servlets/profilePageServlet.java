package Servlets;

import db.DBManager;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/profilePageUser")
public class profilePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("profilePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String full_name = req.getParameter("full_name");
        String password = req.getParameter("password");
        String repeatpass = req.getParameter("repeatpass");

        if (password.equals(repeatpass)) {
            User user = new User();
            user.setFull_name(full_name);
            user.setPassword(password);
            DBManager.updateUser(user);
            resp.sendRedirect("/news");
        }
    }
}
