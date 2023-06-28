<%
    String opcion = request.getParameter("opcion");
%>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark  bg-dark" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Venta de ropas</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("venta") ? "active" : "")%>" href="VentaController">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("cliente") ? "active" : "")%>" href="ClienteController">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("categoria") ? "active" : "")%>" href="CategoriaController">Categoria</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("marca") ? "active" : "")%>" href="MarcaController">Marca</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("vendedor") ? "active" : "")%>" href="VendedorController">Vendedor</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("producto") ? "active" : "")%>" href="ProductoController">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("tienda") ? "active" : "")%>" href="TiendaController">Tiendas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("orden") ? "active" : "")%>" href="OrdenController">Ordenes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= (opcion.equals("usuario") ? "active" : "")%>" href="UsuarioController">Usuarios</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <a href="LoginController?action=logout" class="btn btn-primary">Cerrar sesion</a>
                </form>
            </div>
        </div>
    </nav>
</header>