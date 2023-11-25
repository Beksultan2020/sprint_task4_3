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

@WebServlet(value = "/signInUser")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("singIn.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect ="/signIn?Error";
        String email=req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session=req.getSession();

        User user= DBManager.getUserByEmail(email);
        session.setAttribute("user",user);

        if(user !=null && user.getEmail().equals(email) && user.getPassword().equals(password)){
            redirect="/profilePageUser";
        }
        resp.sendRedirect(redirect);

    }
}
