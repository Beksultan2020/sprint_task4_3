package Servlets;

import db.DBManager;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/registerUser")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect="redirect?emailError";
        String full_name=req.getParameter("full_name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String repeatpass=req.getParameter("repeatpass");

        User existUser = DBManager.getUserByEmail(email);

        if(existUser == null){
            redirect="/redirect?password";
            if(password.equals(repeatpass)){
                User user =new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setFull_name(full_name);
                DBManager.addUser(user);
                redirect="/signInUser";
            }
        }

        resp.sendRedirect(redirect);
    }
}
