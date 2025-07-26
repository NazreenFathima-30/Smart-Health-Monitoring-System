@WebServlet("/insert")
public class InsertDataServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name = req.getParameter("name");
    float temp = Float.parseFloat(req.getParameter("temp"));
    int rate = Integer.parseInt(req.getParameter("rate"));
    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("INSERT INTO health_data (patient_name, temperature, heart_rate) VALUES (?, ?, ?)");
      ps.setString(1, name);
      ps.setFloat(2, temp);
      ps.setInt(3, rate);
      ps.executeUpdate();
      res.sendRedirect("view");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
