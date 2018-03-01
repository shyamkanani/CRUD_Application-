import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie ck=new Cookie("id","");
        ck.setMaxAge(0);
        response.addCookie(ck);
        response.sendRedirect("index.html?msg=YouLogOutSuccessfully");
    }
}
