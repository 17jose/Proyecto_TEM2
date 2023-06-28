package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAOimple;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.DAO.ClienteDAO;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ClienteDAO dao = new ClienteDAOimple();
            Cliente cli = new Cliente();
            int ci;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("clientes", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    ci = Integer.parseInt(request.getParameter("ci"));
                    //obtener el objeto que corresponde al registro
                    cli = dao.getByCi(ci);
                    //colocar como atributo
                    request.setAttribute("clientes", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);
                    break;

                case "delete":
                    ci = Integer.parseInt(request.getParameter("ci"));
                    dao.delete(ci);
                    response.sendRedirect("ClienteController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
        int ci = Integer.parseInt(request.getParameter("ci"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String celular = request.getParameter("celular");

        Cliente cli = new Cliente();
        cli.setId(id);
        cli.setCi(ci);
        cli.setNombre(nombre);
        cli.setApellidos(apellidos);
        cli.setCelular(celular);

        ClienteDAO dao = new ClienteDAOimple();

        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else{
            //edicion
            try {
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("ClienteController");
    }
}
