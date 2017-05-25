package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("loginUser")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN="login";
    private static final String PASSWORD="passwodr";

@Override
    protected void service (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String this_login=request.getParameter(LOGIN);
        String this_password=request.getParameter(PASSWORD);
        RegistrationServlet a=new RegistrationServlet();

        if (!this_login.equals("")&&!this_password.equals("")){
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out=response.getWriter();
            for (LoginBase user: a.getUsers()){
                if (this_login.equals(user.getLogin())&&this_password.equals(user.getPassword())){
                    request.setAttribute("name",this_login);
                    request.getRequestDispatcher("authorizationSuccessful").forward(request,response);
                }
            }
        }

    }
}