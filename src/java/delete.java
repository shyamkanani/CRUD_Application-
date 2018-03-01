import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

public class delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
                Statement st=cn.createStatement();
                ResultSet rs;
                int flag=0;
                rs=st.executeQuery("select * from crud where id = "+Integer.parseInt(request.getParameter("id")));
                String ps=request.getParameter("password");
                while(rs.next())
                {
                    if(ps.equals(rs.getString("password")))
                    {
                        flag++;
                    }
                }
                if(flag==0)
                {
                    response.sendRedirect("profile?msg=YouEnteredWrongPassword");
                }
                else
                {
                    if(request.getParameter("id")!=null){
                    String dquery = "delete from crud where id="+Integer.parseInt(request.getParameter("id"));
                    st.executeUpdate(dquery);
                    response.sendRedirect("index.html?msg=YourAccountIsDeletedSuccessfully");
                    }
                }
            }
            catch(ClassNotFoundException e)
            {
                System.out.println("<p> Error :</p>"+e.getMessage());
            }
            catch(SQLException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }
    }
}
