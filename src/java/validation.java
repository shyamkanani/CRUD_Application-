import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.*;

public class validation extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
                 response.setContentType("text/html;charset=UTF-8");
                 PrintWriter out = response.getWriter();
                 
            try
            {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
            String sqlQuery = "select * from crud where username=? and password=? ";
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, request.getParameter("username"));
            pst.setString(2, request.getParameter("password"));
            ResultSet rs=pst.executeQuery();
            int flag=0;
            while(rs.next()){
                
                flag=flag+1;
                String s=String.valueOf(rs.getInt("id"));
                Cookie ck=new Cookie("id",s);
                response.addCookie(ck);
            }
            if(flag==0)
            {
                 out.print("<h3 style=\"color:red; text-align:center \">Sorry UserName Or Password Are Incorrect! </h3>"); 
                 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
                 rd.include(request, response);
            }
            else if(flag==1)
            {
                response.sendRedirect("profile");
            }
            }
            catch(ClassNotFoundException e)
            {
                   System.out.println(e.getMessage());
            }
            catch(SQLException e)
            {
                   System.out.println(e.getMessage());
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
    }
}
