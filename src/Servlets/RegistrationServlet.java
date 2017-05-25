package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("newUser")
public class RegistrationServlet extends HttpServlet {
    private static final String LOGIN="new_login";
    private static final String PASSWORD="new_password";
    private ArrayList<LoginBase> users=new ArrayList<>();


@Override
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String this_login=request.getParameter(LOGIN);
        String this_Password=request.getParameter(PASSWORD);
        String this_ip=request.getRemoteAddr();

        if (!this_login.equals("")&&!this_Password.equals("")){
            users.add(new LoginBase(this_login,this_Password,this_ip));
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out=response.getWriter();
            request.setAttribute("name",this_login);
            request.getRequestDispatcher("registration.jsp").forward(request,response);
        }


    }
    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public ArrayList<LoginBase> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<LoginBase> users) {
        this.users = users;
    }

}
