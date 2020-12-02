
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrderServlet extends HttpServlet {  // JDK 6 and above only

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

         out.println("<html><head><title>Order Confirmation</title></head><body>");
         out.println("<h2>YOUR NBA ONE STOP - Order Confirmation</h2>");

         // Retrieve and process request parameters: id(s), cust_name, cust_email, cust_phone
         String[] ids = request.getParameterValues("id");  // Possibly more than one values
         String custName = request.getParameter("cust_name");
         boolean hasCustName = custName != null && ((custName = custName.trim()).length() > 0);
         String custEmail = request.getParameter("cust_email").trim();
         boolean hasCustEmail = custEmail != null && ((custEmail = custEmail.trim()).length() > 0);
         String custPhone = request.getParameter("cust_phone").trim();
         boolean hasCustPhone = custPhone != null && ((custPhone = custPhone.trim()).length() > 0);





         // Validate inputs
         if (ids == null || ids.length == 0) {
            out.println("<h3>Please Select a Jersey</h3>");
          }  else if (!hasCustName) {
            out.println("<h3>Please Enter Your Name!</h3>");
         } else if (!hasCustEmail || (custEmail.indexOf('@') == -1)) {
            out.println("<h3>Please Enter Your e-mail (user@host)!</h3>");
         } else if (!hasCustPhone || (custPhone.length() != 8)) {
            out.println("<h3>Please Enter an 8-digit Phone Number!</h3>");
         } else {
            // Display the name, email and phone (arranged in a table)

            out.println("<table>");
            out.println("<tr><td>Customer Name:</td><td>" + custName + "</td></tr>");
            out.println("<tr><td>Customer Email:</td><td>" + custEmail + "</td></tr>");
            out.println("<tr><td>Customer Phone Number:</td><td>" + custPhone + "</td></tr></table>");



            // Print the book(s) ordered in a table
            out.println("<br />");
            out.println("<table border='1' cellpadding='6'>");
            out.println("<tr><th>NAME</th><th>Team</th><th>SIZE</th><th>PRICE</th><th>QTY</th></tr>");

            float totalPrice = 0f;
            for (String id : ids) {
          String  sqlStr = "SELECT * FROM jersey WHERE id = " + id;
               //System.out.println(sqlStr);  // for debugging
              ResultSet rset = stmt.executeQuery(sqlStr);
                 int qtyOrdered = Integer.parseInt(request.getParameter("qty" + id));
               // Expect only one row in ResultSet
               rset.next();
               String size = rset.getString("size");
               String team = rset.getString("team");
               int qtyAvailable = rset.getInt("qty");
               String name = rset.getString("name");
               float price = rset.getFloat("price");

              if(qtyOrdered>qtyAvailable){
                out.println("<h3>Sorry! The following products are out of stock.</h3>");
                out.println("<tr>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + team + "</td>");
                out.println("<td>" + size + "</td></tr>");
              }else{

               sqlStr = "UPDATE jersey SET qty = qty - " + qtyOrdered + " WHERE id = " + id;
               //System.out.println(sqlStr);  // for debugging
               stmt.executeUpdate(sqlStr);

               sqlStr = "INSERT INTO order_records values ("
                       + id + ", " + qtyOrdered + ", '" + custName + "', '"
                       + custEmail + "', '" + custPhone + "')";
               System.out.println(sqlStr);  // for debugging
               stmt.executeUpdate(sqlStr);

               // Display this book ordered
               out.println("<tr>");
               out.println("<td>" + name + "</td>");
               out.println("<td>" + team + "</td>");

               out.println("<td>" + size + "</td>");
               out.println("<td>" + price + "</td>");
               out.println("<td>" + qtyOrdered + "</td></tr>");
               totalPrice += price * qtyOrdered;
             }
            }

            out.println("<tr><td colspan='5' align='right'>Total Price: $");
            out.printf("%.2f</td></tr>", totalPrice);
            out.println("</table>");

            out.println("<h3>Thank you.</h3>");
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

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      doGet(request, response);
   }

}
