package com.emergentes.controlador;

import com.emergentes.DAO.TiendaDAO;
import com.emergentes.DAO.TiendaDAOimple;
import com.emergentes.modelo.Tienda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TiendaController", urlPatterns = {"/TiendaController"})
public class TiendaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TiendaDAO dao = new TiendaDAOimple();
            Tienda t = new Tienda();
            int id_tienda;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("tiendas", t);
                    request.getRequestDispatcher("frmTienda.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    id_tienda = Integer.parseInt(request.getParameter("id_tienda"));
                    //obtener el objeto que corresponde al registro
                    t = dao.getByCi(id_tienda);
                    //colocar como atributo
                    request.setAttribute("tiendas", t);
                    request.getRequestDispatcher("frmTienda.jsp").forward(request, response);
                    break;

                case "delete":
                    id_tienda = Integer.parseInt(request.getParameter("id_tienda"));
                    dao.delete(id_tienda);
                    response.sendRedirect("TiendaController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Tienda> lista = dao.getAll();
                    request.setAttribute("tiendas", lista);
                    request.getRequestDispatcher("tienda.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_tienda = Integer.parseInt(request.getParameter("id_tienda"));
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        Tienda t = new Tienda();
        t.setId_tienda(id_tienda);
        t.setDireccion(direccion);
        t.setCiudad(ciudad);
        t.setTelefono(telefono);
        
        TiendaDAO dao = new TiendaDAOimple();

        if (id_tienda == 0) {
            try {
                //nuevo registro
                dao.insert(t);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else{
            //edicion
            try {
                dao.update(t);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("TiendaController");
    }
    }
