// Saved as "ebookshop\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class showproducts extends HttpServlet {  // JDK 6 and above only

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();

      Connection conn = null;
      Statement stmt = null;
      try {
         // Step 1: Create a database "Connection" object
         // For MySQL
         Class.forName("com.mysql.jdbc.Driver");  // Needed for JDK9/Tomcat9
         conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/eshop?useSSL=false&serverTimezone=UTC", "myuser", "xxxx");  // <<== Check

         // Step 2: Create a "Statement" object inside the "Connection"
         stmt = conn.createStatement();

         // Step 3: Execute a SQL SELECT query
         String sqlStr = "SELECT * FROM jersey where name = "
                   + "'" + request.getParameter("name") + "'";


             // Print an HTML page as output of query
             out.println("<html><head><title>Query Results</title></head><body>");
             out.println("<h2>Thank you for your query.</h2>");
             out.println("<p>You query is: " + sqlStr + "</p>"); // Echo for debugging
             ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the server

             // Step 4: Process the query result

             if (!rset.next()) {  // Check for empty ResultSet (no book found)
              out.println("<h3>No RECORD FOUND. Please try again!</h3>");
              out.println("<p><a href='allproducts.html'>Back to Select Menu</a></p>");
           } else {
              // Print the result in an HTML form inside a table
              out.println("<form method='get' action='order'>");
              out.println("<table border='1' cellpadding='6'>");
              out.println("<tr>");
              out.println("<th>&nbsp;</th>");
              out.println("<th>NAME</th>");
              out.println("<th>TEAM</th>");
              out.println("<th>SIZE</th>");
              out.println("<th>PRICE</th>");
              out.println("<th>QTY</th>");
              out.println("</tr>");

              do {
                 // Print each row with a checkbox identified by book's id
                 String id = rset.getString("id");
                 out.println("<tr>");
                 out.println("<td><input type='checkbox' name='id' value='" + id + "' /></td>");
                 out.println("<td>" + rset.getString("name") + "</td>");
                 out.println("<td>" + rset.getString("team") + "</td>");
                 out.println("<td>$" + rset.getString("size") + "</td>");
                 out.println("<td>$" + rset.getDouble("price") + "</td>");
                 out.println("<td><input type='text' size='3' value='1' name='qty" + id + "' /></td>");
                 out.println("</tr>");
              } while (rset.next());
              out.println("</table><br />");

             // Ask for name, email and phone using text fields (arranged in a table)
                 out.println("<table>");
                 out.println("<tr><td>Enter your Name:</td>");
                 out.println("<td><input type='text' name='cust_name' /></td></tr>");
                 out.println("<tr><td>Enter your Email (user@host):</td>");
                 out.println("<td><input type='text' name='cust_email' /></td></tr>");
                 out.println("<tr><td>Enter your Phone Number (8-digit):</td>");
                 out.println("<td><input type='text' name='cust_phone' /></td></tr></table><br />");

                 // Submit and reset buttons
                 out.println("<input type='submit' value='ORDER' />");
                 out.println("<input type='reset' value='CLEAR' /></form>");

                 // Hyperlink to go back to search menu
                 out.println("<p><a href='allproducts.html'>Back to Select Menu</a></p>");
              }

           out.println("</body></html>");
    } catch (SQLException ex) {
         ex.printStackTrace();
     } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
     } finally {
         out.close();
         try {
            // Step 5: Close the Statement and Connection
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
      }
   }
}
