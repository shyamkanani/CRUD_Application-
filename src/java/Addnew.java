import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class Addnew extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
                Connection cn=null;
                Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
                Statement st=cn.createStatement();
                ResultSet rs;
                int flag=0;
                rs=st.executeQuery("select * from crud");
                
                int id=Integer.parseInt(request.getParameter("id"));
                while(rs.next())
                {
                    if(rs.getInt("id")==id)
                        flag++;
                }
                if(flag==0){
                    String name=request.getParameter("username");
                    String email=request.getParameter("email");
                    String pwd=request.getParameter("password");
                    String country=request.getParameter("country");
                    String u="user";
                    PreparedStatement pst = cn.prepareStatement("insert into crud values(?,?,?,?,?,?)");
                    pst.setInt(1,id);
                    pst.setString(2,name);
                    pst.setString(3,pwd);
                    pst.setString(4,u);
                    pst.setString(6,email);
                    pst.setString(5,country);
                    pst.executeUpdate();
                    response.sendRedirect("index.html");
                }
                else
                {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.print("<h3 style=\"color:red; text-align:center \">Sorry, Entered id is already registered so, please insert different id.</h3>"); 
                    RequestDispatcher rd=request.getRequestDispatcher("insert.html");  
                    rd.include(request, response);
                }
            }
            catch(ClassNotFoundException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }catch(SQLException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }
            catch(Exception e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }
    }
}