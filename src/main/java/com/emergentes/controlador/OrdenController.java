package com.emergentes.controlador;

import com.emergentes.DAO.OrdenDAO;
import com.emergentes.DAO.OrdenDAOimple;
import com.emergentes.modelo.Orden;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrdenController", urlPatterns = {"/OrdenController"})
public class OrdenController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            OrdenDAO dao = new OrdenDAOimple();
            Orden ord = new Orden();
            int orden_id;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("ordenes", ord);
                    request.getRequestDispatcher("frmOrden.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    orden_id = Integer.parseInt(request.getParameter("orden_id"));
                    //obtener el objeto que corresponde al registro
                    ord = dao.getByCi(orden_id);
                    //colocar como atributo
                    request.setAttribute("ordenes", ord);
                    request.getRequestDispatcher("frmOrden.jsp").forward(request, response);
                    break;

                case "delete":
                    orden_id = Integer.parseInt(request.getParameter("orden_id"));
                    dao.delete(orden_id);
                    response.sendRedirect("OrdenController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Orden> lista = dao.getAll();
                    request.setAttribute("ordenes", lista);
                    request.getRequestDispatcher("orden.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orden_id = Integer.parseInt(request.getParameter("orden_id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        double total = Double.parseDouble(request.getParameter("total"));
        double descuento = Double.parseDouble(request.getParameter("descuento"));
        String fecha_orden = request.getParameter("fecha_orden");
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        int id_venta = Integer.parseInt(request.getParameter("id_venta"));

        Orden ord = new Orden();
        ord.setOrden_id(orden_id);
        ord.setCantidad(cantidad);
        ord.setTotal(total);
        ord.setDescuento(descuento);
        ord.setFecha_orden(fecha_orden);
        ord.setProducto_id(producto_id);
        ord.setId_venta(id_venta);
        

        OrdenDAO dao = new OrdenDAOimple();

        if (orden_id == 0) {
            try {
                //nuevo registro
                dao.insert(ord);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else{
            //edicion
            try {
                dao.update(ord);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("OrdenController");
    }
    }
