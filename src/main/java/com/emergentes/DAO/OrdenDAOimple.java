package com.emergentes.DAO;

import com.emergentes.modelo.Orden;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenDAOimple extends conexionBD implements OrdenDAO {

    @Override
    public void insert(Orden orden) throws Exception {
        try {
            this.conectar();
            String sql = "insert into orden (cantidad, total, descuento, fecha_orden, producto_id, id_venta) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orden.getCantidad());
            ps.setDouble(2, orden.getTotal());
            ps.setDouble(3, orden.getDescuento());
            ps.setString(4, orden.getFecha_orden());
            ps.setInt(5, orden.getProducto_id());
            ps.setInt(6, orden.getId_venta());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Orden orden) throws Exception {
        try {
            this.conectar();
            String sql = "update orden set cantidad=?, total=?, descuento=?, producto_id=? where orden_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orden.getCantidad());
            ps.setDouble(2, orden.getTotal());
            ps.setDouble(3, orden.getDescuento());
           ps.setInt(5, orden.getProducto_id());
            ps.setInt(6, orden.getOrden_id());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int orden_id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from categoria where orden_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orden_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Orden> getAll() throws Exception {
        List<Orden> lista = null;
        try {
            this.conectar();
            String sql = "select * from orden";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Orden>();

            while (rs.next()) {
                Orden ord = new Orden();
                ord.setOrden_id(rs.getInt("orden_id"));
                ord.setCantidad(rs.getInt("cantidad"));
                ord.setTotal(rs.getDouble("total"));
                ord.setDescuento(rs.getDouble("descuento"));
                ord.setFecha_orden(rs.getString("fecha_orden"));
                ord.setProducto_id(rs.getInt("producto_id"));
                ord.setId_venta(rs.getInt("id_venta"));

                lista.add(ord);
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
    public Orden getByCi(int orden_id) throws Exception {
        Orden ord = new Orden();
        try {
            this.conectar();
            String sql = "select * from orden where orden_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orden_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ord.setOrden_id(rs.getInt("orden_id"));
                ord.setCantidad(rs.getInt("cantidad"));
                ord.setTotal(rs.getDouble("total"));
                ord.setDescuento(rs.getDouble("descuento"));
                ord.setFecha_orden(rs.getString("fecha_orden"));
                ord.setProducto_id(rs.getInt("producto_id"));
                ord.setId_venta(rs.getInt("id_venta"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ord;
    }}