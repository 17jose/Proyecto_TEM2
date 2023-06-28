package com.emergentes.controlador;

import com.emergentes.DAO.CategoriaDAO;
import com.emergentes.DAO.CategoriaDAOimple;
import com.emergentes.modelo.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CategoriaDAO dao = new CategoriaDAOimple();
            Categoria cat = new Categoria();
            int categoria_id;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("categorias", cat);
                    request.getRequestDispatcher("frmCategoria.jsp").forward(request, response);
                    break;

                case "edit":
                    //AcisoController?action=edit&ci=#
                    categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
                    //obtener el objeto que corresponde al registro
                    cat = dao.getByCi(categoria_id);
                    //colocar como atributo
                    request.setAttribute("categorias", cat);
                    request.getRequestDispatcher("frmCategoria.jsp").forward(request, response);
                    break;

                case "delete":
                    categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
                    dao.delete(categoria_id);
                    response.sendRedirect("CategoriaController");
                    break;

                case "view":
                    //obtener lista de 
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("categoria.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        String categoria = request.getParameter("categoria");
        
        Categoria cat = new Categoria();
        cat.setCategoria_id(categoria_id);
        cat.setCategoria(categoria);
        
        CategoriaDAO dao = new CategoriaDAOimple();

        if (categoria_id == 0) {
            try {
                //nuevo registro
                dao.insert(cat);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //edicion
            try {
                dao.update(cat);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("CategoriaController");
    }
}

