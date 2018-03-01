import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class display extends HttpServlet {
    
    
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
                   out.println("</head>");
                   out.println("<title>Dashboard</title>");
                   out.println("<body>");
                   
                   out.println("<nav class='navbar navbar-light bg-light'>");
                   out.println("<a class='navbar-brand' href='#'><img src='my.png' width='30' height='30' alt='SK' >  CRUD Application</a>");
                   out.println("<ul class='nav nav-tabs'>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link ' href='profile'>Profile</a>");
                   out.println("</li>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link active' href='display'> DashBoard </a>");
                   out.println("</li>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link' href='about.html'>About</a>");
                   out.println("</li>");
                   out.println("<li class='nav-item'>");
                   out.println("<a class='nav-link' href='logout'>Log Out</a>");
                   out.println("</li>");
                   out.println("</ul>");
                   out.println("</nav>");
     
                   try
                   {
                        //out.print("<h3 style='color:blue; text-align:center '> Welcome </h3>");
                        //out.print("<h3 ><a href='profile'>Profile </a><a href='display'> Dashboard </a> <a href='logout'>Log Out</a></h3>");
                        out.println("<br/>");
                        out.println("<table class='table table-striped table-dark' border='2'>");
                        out.println("<thead>");
                        out.println("<tr><th colspan='8'><a href='#' class='alert-link' ><h5 class='alert alert-light' role='alert' align='center'> DashBoard </h5> </a></th></tr>");
                        out.println("<tr><th>#</th><th>Username</th><th>Password</th><th>User</th><th>Email</th><th>Country</th>");
                        out.println("</thead>");
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection cn=null;
                        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
                        Statement st=cn.createStatement();
                        ResultSet rs;
                        rs=st.executeQuery("select * from crud");
                        int count=0;
                        while(rs.next())
                        {
                            String check=rs.getString("user");
                            count++;
                            out.println("<tbody>");
                            out.println("<tr>");
                            out.println("<td>"+rs.getInt("id")+"</th>");
                            out.println("<td>"+rs.getString("username")+"</td>");
                            out.println("<td> ******** </td>");
                            out.println("<td>"+rs.getString("user")+"</td>"); 
                            out.println("<td>"+rs.getString("email")+"</td>");              
                            out.println("<td>"+rs.getString("country")+"</td>");
                            out.println("</tr>"); 
                            out.println("<tbody>");
                        }
                        if(count==0)
                        {
                            out.println("<tr><th colspan='6'><h2> No Users Found</h2></th></tr>");
                        }
                        out.println("</table>");
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
