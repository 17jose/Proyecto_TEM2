package com.emergentes.controlador;
import com.emergentes.utiles.conexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (request.getParameter("action") == null)?"view":request.getParameter("action");
        
        if(action.equals("logout")){
            HttpSession ses = request.getSession();
            ses.invalidate();
        }
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            String sql = "select * from usuarios where correo=? and password=md5(?)";
            ResultSet rs;
                    
                    conexionBD canal = new conexionBD();
                    Connection cn = canal.conectar();
                    
                    PreparedStatement ps = cn.prepareStatement(sql);
                    ps.setString(1, correo);
                    ps.setString(2, password);
                    
                    rs = ps.executeQuery();
                    
                    if(rs.next()){
                        HttpSession ses = request.getSession();
                        
                        ses.setAttribute("logueado", "ok");
                        ses.setAttribute("usuario", rs.getString("nombres")+""+rs.getString("apellidos"));
                        response.sendRedirect("ClienteController");
                    }
                    else{
                        response.sendRedirect("login.jsp");
                    }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos "+ ex.getMessage());        
        }
    }
}
