package com.emergentes.controlador;

import com.emergentes.DAO.UsuarioDAO;
import com.emergentes.DAO.UsuarioDAOimple;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO dao = new UsuarioDAOimple();
            Usuario u = new Usuario();
            int id;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("usuarios", u);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    id = Integer.parseInt(request.getParameter("id"));
                    //obtener el objeto que corresponde al registro
                    u = dao.getByCi(id);
                    //colocar como atributo
                    request.setAttribute("usuarios", u);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        Usuario u = new Usuario();
        u.setId(id);
        u.setNombres(nombres);
        u.setApellidos(apellidos);
        u.setCorreo(correo);
        u.setPassword(password);

        UsuarioDAO dao = new UsuarioDAOimple();

        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(u);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //edicion
            try {
                dao.update(u);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioController");
    }
}
