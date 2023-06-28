package com.emergentes.controlador;

import com.emergentes.DAO.VentaDAO;
import com.emergentes.DAO.VentaDAOimple;
import com.emergentes.modelo.Venta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VentaDAO dao = new VentaDAOimple();
            Venta ven = new Venta();
            int id_venta;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("ventas", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);
                    break;

                case "edit":
                    //MainController?action=edit&ci=#
                    id_venta = Integer.parseInt(request.getParameter("id_venta"));
                    //obtener el objeto que corresponde al registro
                    ven = dao.getByCi(id_venta);
                    //colocar como atributo
                    request.setAttribute("ventas", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);
                    break;

                case "delete":
                    id_venta = Integer.parseInt(request.getParameter("id_venta"));
                    dao.delete(id_venta);
                    response.sendRedirect("VentaController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Venta> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("venta.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        int id_venta = Integer.parseInt(request.getParameter("id_venta"));
        String fecha = request.getParameter("fecha");
        int tienda_id = Integer.parseInt(request.getParameter("tienda_id"));
        int ci_vendedor = Integer.parseInt(request.getParameter("ci_vendedor"));
        int ci_cliente = Integer.parseInt(request.getParameter("ci_cliente"));

        Venta ven = new Venta();
        
        ven.setIdventa(id_venta);
        ven.setFecha(fecha);
        ven.setTienda_id(tienda_id);
        ven.setCi_vendedor(ci_vendedor);
        ven.setCi_cliente(ci_cliente);
        
        VentaDAO dao = new VentaDAOimple();

        if (id_venta == 0) {
            try {
                //nuevo registro
                dao.insert(ven);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else{
            //edicion
            try {
                dao.update(ven);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("VentaController");
    }
    }
