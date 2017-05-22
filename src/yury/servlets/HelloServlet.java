package yury.servlets;

import yury.utils.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class HelloServlet extends HttpServlet {

    private static final String FIRST_NAME_PARAM = "txt_first_name";

    private static final String LAST_NAME_PARAM = "txt_last_name";

    private static final String FIRST_NAME_DEFAULT = "NoName";

    private static final String LAST_NAME_DEFAULT = "NoName";

    ArrayList<String> message = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter(FIRST_NAME_PARAM);
        if (StringUtils.isBlank(firstName)) {
            firstName = FIRST_NAME_DEFAULT;
        }
        firstName = StringUtils.capitalizeFirstLetter(firstName);

        String lastName = request.getParameter(LAST_NAME_PARAM);
        if (StringUtils.isBlank(lastName)) {
            lastName = LAST_NAME_DEFAULT;
        }
        lastName = StringUtils.capitalizeFirstLetter(lastName);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        message.add(firstName+": "+lastName+" ; ");


        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Hello Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Hello Page</h1>");
        out.println("</center>");
        String mes="";
        for (int i = 0; i < message.size(); i++) {
            mes = message.get(i);
            out.println("<h1>"+mes+"</h1>");
        }
       out.println("<form action='hello.do' method='post'>");
   out.println("<table>");
       out.println("<tr>");
            out.println("<td>Имя:</td>");
            out.println("<td>");
        out.println("<input type='text' name='txt_first_name' />");
        out.println("</td>");
        out.println ("</tr>");
        out.println ("<tr>");
        out.println ("<td>Сообщение:</td>");
                out.println("<td>");
                out.println ("<input type='text' name='txt_last_name' />");
                out.println ("</td>");
                out.println ("</tr>");
                out.println ("<tr>");
                out.println ("<td colspan='2' align='right'>");
                out.println ("<input type='submit' value='Продолжить' />");
                out.println ("</td>");
                out.println ("</tr>");
                out.println ("</table>");
                out.println ("</form>");
                out.println("<a href=\"" + request.getServletContext().getContextPath() + "/index.html\">На главную</a>");
        out.println("</html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }



}