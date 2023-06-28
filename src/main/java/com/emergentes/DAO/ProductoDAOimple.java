package com.emergentes.DAO;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimple extends conexionBD implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "insert into producto (nombre_prod, precio, stock_id, marca_id, categoria_id) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre_prod());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getStock_id());
            ps.setInt(4, producto.getMarca_id());
            ps.setInt(5, producto.getCategoria_id());
            
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "update producto set nombre_prod=?, precio=?, stock_id=?, marca_id=?, categoria_id=? where producto_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre_prod());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getStock_id());
            ps.setInt(4, producto.getMarca_id());
            ps.setInt(5, producto.getCategoria_id());
            ps.setInt(6, producto.getProducto_id());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int producto_id) throws Exception {
        try {
            this.conectar();
            String sql ="delete from producto where producto_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, producto_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        try {
            this.conectar();
            String sql = "select * from producto";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Producto>();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setProducto_id(rs.getInt("producto_id"));
                prod.setNombre_prod(rs.getString("nombre_prod"));
                prod.setPrecio(rs.getInt("precio"));
                prod.setStock_id(rs.getInt("stock_id"));
                prod.setMarca_id(rs.getInt("marca_id"));
                prod.setCategoria_id(rs.getInt("categoria_id"));
                
                lista.add(prod);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Producto getByCi(int producto_id) throws Exception {
        Producto prod = new Producto();
        try {
            this.conectar();
            String sql = "select * from producto where producto_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, producto_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prod.setProducto_id(rs.getInt("producto_id"));
                prod.setNombre_prod(rs.getString("nombre_prod"));
                prod.setPrecio(rs.getInt("precio"));
                prod.setStock_id(rs.getInt("stock_id"));
                prod.setMarca_id(rs.getInt("marca_id"));
                prod.setCategoria_id(rs.getInt("categoria_id"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prod;
    }
}