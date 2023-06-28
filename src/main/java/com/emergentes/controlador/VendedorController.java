package com.emergentes.controlador;

import com.emergentes.DAO.VendedorDAO;
import com.emergentes.DAO.VendedorDAOimple;
import com.emergentes.modelo.Vendedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VendedorController", urlPatterns = {"/VendedorController"})
public class VendedorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VendedorDAO dao = new VendedorDAOimple();
            Vendedor ven = new Vendedor();
            int id;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("vendedores", ven);
                    request.getRequestDispatcher("frmVendedor.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    id = Integer.parseInt(request.getParameter("id"));
                    //obtener el objeto que corresponde al registro
                    ven = dao.getByCi(id);
                    //colocar como atributo
                    request.setAttribute("vendedores", ven);
                    request.getRequestDispatcher("frmVendedor.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VendedorController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Vendedor> lista = dao.getAll();
                    request.setAttribute("vendedores", lista);
                    request.getRequestDispatcher("vendedor.jsp").forward(request, response);
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
        int ci_vendedor = Integer.parseInt(request.getParameter("ci_vendedor"));
        String nombre_vendedor = request.getParameter("nombre_vendedor");
        String apellido_paterno = request.getParameter("apellido_paterno");
        String apellido_materno = request.getParameter("apellido_materno");
        int celular = Integer.parseInt(request.getParameter("celular"));
        int id_tienda = Integer.parseInt(request.getParameter("id_tienda"));

        Vendedor ven = new Vendedor();
        ven.setId(id);
        ven.setCi_vendedor(ci_vendedor);
        ven.setNombre_vendedor(nombre_vendedor);
        ven.setApellido_paterno(apellido_paterno);
        ven.setApellido_materno(apellido_materno);
        ven.setCelular(celular);
        ven.setId_tienda(id_tienda);

        VendedorDAO dao = new VendedorDAOimple();

        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(ven);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //edicion
            try {
                dao.update(ven);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("VendedorController");
    }
}
