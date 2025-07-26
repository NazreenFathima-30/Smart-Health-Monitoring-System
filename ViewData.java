@WebServlet("/view")
public class ViewDataServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    try {
      Connection con = DBConnection.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM health_data");
      out.println("<h2>Patient Records</h2><table border='1'>");
      out.println("<tr><th>Name</th><th>Temp</th><th>HR</th><th>Time</th></tr>");
      while (rs.next()) {
        out.println("<tr><td>" + rs.getString("patient_name") + "</td><td>" +
                    rs.getFloat("temperature") + "</td><td>" +
                    rs.getInt("heart_rate") + "</td><td>" +
                    rs.getTimestamp("recorded_at") + "</td></tr>");
      }
      out.println("</table>");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
