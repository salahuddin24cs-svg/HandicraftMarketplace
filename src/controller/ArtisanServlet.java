package controller;
import dao.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ArtisanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS artisan("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(100),"
                + "location VARCHAR(100),"
                + "contact VARCHAR(15))");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO artisan(name,location,contact) VALUES(?,?,?)");

            ps.setString(1, req.getParameter("name"));
            ps.setString(2, req.getParameter("location"));
            ps.setString(3, req.getParameter("contact"));
            ps.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
        res.sendRedirect("artisan.jsp");
    }
}
