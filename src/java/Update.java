import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

public class Update extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                   response.setContentType("text/html;charset=UTF-8");
                   PrintWriter out = response.getWriter();
                try{
                Connection cn=null;
                Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
            String query ="update crud set username=?,password=?,email=? where id=?";
            PreparedStatement pst=cn.prepareStatement(query);
            pst.setString(1,request.getParameter("username"));
            pst.setString(2,request.getParameter("password"));
            pst.setString(3,request.getParameter("email"));
            pst.setInt(4,Integer.parseInt(request.getParameter("id")));
            
            if(pst.executeUpdate()==1)
            {
                response.sendRedirect("profile?msg=success");
            }
            else
            {
                response.sendRedirect("profile?msg=error");
            }
            }
            catch(ClassNotFoundException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }catch(SQLException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }
            catch(Exception e){
                System.out.println("<p> Error :</p>"+e.getMessage());
                e.printStackTrace();
            }
    }
}
