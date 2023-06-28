<%
if(session.getAttribute("logueado")!="ok"){
    response.sendRedirect("login.jsp");
}
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        
        <title>TIENDA DE ROPAS</title>
    </head>
    <body>
        <div class="container">
            <h1>Ventas</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="venta"/>
            </jsp:include>            
            <br>
            <a href="VentaController?action=add" class="btn btn-primary btn-sm"><i class="fa-regular fa-square-plus"></i> Nuevo</a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Fecha</th>
                    <th>Tienda</th>
                    <th>Vendedor</th>
                    <th>Cliente</th>      
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${ventas}">
                <tr>
                    <td>${item.id_venta}</td>
                    <td>${item.fecha}</td>
                    <td>${item.tienda_id}</td>
                    <td>${item.ci_vendedor}</td>
                    <td>${item.ci_cliente}</td>
                    <th><a href="VentaController?action=edit&id_venta=${item.id_venta}"><i class="fa-solid fa-pen-to-square"></i>Editar</a></th>
                    <th><a href="VentaController?action=delete&id_venta=${item.id_venta}" onclick="return(confirm('Esta seguro de eliminar???'))"><i class="fa-solid fa-trash"></i>Eliminar</a></th>

                </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
