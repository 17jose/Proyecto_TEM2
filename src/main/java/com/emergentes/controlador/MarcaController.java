package com.emergentes.controlador;

import com.emergentes.DAO.MarcaDAO;
import com.emergentes.DAO.MarcaDAOimple;
import com.emergentes.modelo.Marca;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MarcaController", urlPatterns = {"/MarcaController"})
public class MarcaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MarcaDAO dao = new MarcaDAOimple();
            Marca mar = new Marca();
            int marca_id;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("marcas", mar);
                    request.getRequestDispatcher("frmMarca.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    marca_id = Integer.parseInt(request.getParameter("marca_id"));
                    //obtener el objeto que corresponde al registro
                    mar = dao.getByCi(marca_id);
                    //colocar como atributo
                    request.setAttribute("marcas", mar);
                    request.getRequestDispatcher("frmMarca.jsp").forward(request, response);
                    break;

                case "delete":
                    marca_id = Integer.parseInt(request.getParameter("marca_id"));
                    dao.delete(marca_id);
                    response.sendRedirect("MarcaController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Marca> lista = dao.getAll();
                    request.setAttribute("marcas", lista);
                    request.getRequestDispatcher("marca.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int marca_id = Integer.parseInt(request.getParameter("marca_id"));
        String marca = request.getParameter("marca");

        Marca mar = new Marca();
        mar.setMarca_id(marca_id);
        mar.setMarca(marca);

        MarcaDAO dao = new MarcaDAOimple();

        if (marca_id == 0) {
            try {
                //nuevo registro
                dao.insert(mar);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //edicion
            try {
                dao.update(mar);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("MarcaController");
    }
}

