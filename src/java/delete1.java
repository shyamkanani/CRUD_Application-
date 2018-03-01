import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class delete1 extends HttpServlet {

/*    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delete1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet delete1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
                   response.setContentType("text/html;charset=UTF-8");
                   PrintWriter out = response.getWriter();
                   out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<head>");
                   out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
                   out.println("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>");
                   out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>");
                   out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>");
                   out.println("<link href='signin.css' rel='stylesheet'>");
                   out.println("</head>");
                   out.println("<title>Delete</title>");
                   out.println("<body style=' margin-top: -40px;'>");

                   out.println("<nav class='navbar navbar-light bg-light'>");
                   out.println("<a class='navbar-brand' href='#'><img src='my.png' width='30' height='30' alt='SK' >  CRUD Application</a>");
                   out.println("<ul class='nav nav-tabs'>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link active' href='profile'>Profile</a>");
                   out.println("</li>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link ' href='display'>Dashboard</a>");
                   out.println("</li>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link' href='about.html'>About</a>");
                   out.println("</li>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link' href='logout'>Log Out</a>");
                   out.println("</li>");
                   out.println("</ul>");
                   out.println("</nav>");
                    try{
                Connection cn=null;
                Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
                Statement st= cn.createStatement();
                ResultSet rs;
                int id=Integer.parseInt(request.getParameter("id"));
                rs=st.executeQuery("select * from crud where id="+id);
                int i=1;
                while(rs.next())
                { 
                    i++; 
                    out.println("<div class='alert alert-danger' role='alert'>");
                    out.println("<h2>Confirmation Box</h2>");
                    out.println("<h4 style='text-align:center;'>To Delete your Account please enter your password </h4>");
                    out.println("<form class='form-signin' action='delete' method='post' >");
                    out.println("<label for='inputid' class='sr-only'>ID</label>");
                    out.println("<input type='hidden' id='inputid' class='form-control' name='id' value='"+request.getParameter("id")+"'>");
                    out.println("<br/>");
                    out.println("<label for='inputPassword' class='sr-only'>Password</label>");
                    out.println("<input type='password' id='inputpassword' class='form-control' placeholder='Enter Password' name='password' required autofocus>");
                    out.println("<button class='btn btn-lg btn-primary btn-block' type='submit'>Submit</button>");
                    out.println("</form>");
                    out.println("</div>");
                    if(i==2){break;}
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    }
