package com.emergentes.controlador;

import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimple;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductoDAO dao = new ProductoDAOimple();
            Producto prod = new Producto();
            int producto_id;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("productos", prod);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    producto_id = Integer.parseInt(request.getParameter("producto_id"));
                    //obtener el objeto que corresponde al registro
                    prod = dao.getByCi(producto_id);
                    //colocar como atributo
                    request.setAttribute("productos", prod);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;

                case "delete":
                    producto_id = Integer.parseInt(request.getParameter("producto_id"));
                    dao.delete(producto_id);
                    response.sendRedirect("ProductoController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        String nombre_prod = request.getParameter("nombre_prod");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int stock_id = Integer.parseInt(request.getParameter("stock_id"));
        int marca_id = Integer.parseInt(request.getParameter("marca_id"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        

        Producto prod = new Producto();
        prod.setProducto_id(producto_id);
        prod.setNombre_prod(nombre_prod);
        prod.setPrecio(precio);
        prod.setStock_id(stock_id);
        prod.setMarca_id(marca_id);
        prod.setCategoria_id(categoria_id);

        ProductoDAO dao = new ProductoDAOimple();

        if (producto_id == 0) {
            try {
                //nuevo registro
                dao.insert(prod);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else{
            //edicion
            try {
                dao.update(prod);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("ProductoController");
    }
    }

