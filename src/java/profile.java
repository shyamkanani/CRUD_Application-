import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class profile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
            out.println("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>");
            out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>");
            out.println("<title>Profile</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<nav class='navbar navbar-light bg-light'>");
            out.println("<a class='navbar-brand' href='#'><img src='my.png' width='30' height='30' alt='SK' >  CRUD Application</a>");
            out.println("<ul class='nav nav-tabs'>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link active' href='profile'>Profile</a>");
            out.println("</li>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link' href='display'>DashBoard </a>");
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=null;
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sk","root","student");
            Statement st=cn.createStatement();
            ResultSet rs;
            int key=0;
            Cookie ck[]=request.getCookies();  
            for(int i=0;i<ck.length;i++)
            {  
                 key = Integer.parseInt(ck[i].getValue());
            }  
            rs=st.executeQuery("select * from crud where id="+key);
            int count=0;
            
            if(rs.next()){
            count++;
             String user=rs.getString("user");
                if(user.equals("admin"))
                {
                    out.print("<h2 style='color:blue; text-align:center '> Welcome  "+rs.getString("username")+"</h2>");
                }    
                if(user.equals("user")) 
                {
                    out.print("<h2 style='color:blue; text-align:center '> Welcome  "+rs.getString("username")+"</h2>");
                }                    
                    out.println("<div class='alert alert-info' role='alert'>");
                    out.print("<h3>ID : "+rs.getInt("id")+"</h3>");
                    out.print("<h3>UserName : "+rs.getString("username")+"</h3>");
                    out.print("<h3>password : "+rs.getString("password")+"</h3>");
                    out.print("<h3>User : "+rs.getString("user")+"</h3>");
                    out.print("<h3>Email ID : "+rs.getString("email")+"</h3>");
                    out.print("<h3>Country : "+rs.getString("country")+"</h3>");
                    out.println("<br/>");
                    out.println("<h3><a class='badge badge-info' href='update1?id="+rs.getInt("id")+"'>Edit</a><a class='badge badge-danger' href='delete1?id="+rs.getInt("id")+"'>Delete</a> </h3>");
                    out.println("</div>");
            }
            if(count==0)
            {
                out.println("<tr><th colspan='6'><h2> No Users Found</h2></th></tr>");
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
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
