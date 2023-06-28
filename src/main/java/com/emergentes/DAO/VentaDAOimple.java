package com.emergentes.DAO;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimple extends conexionBD implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
         try {
            this.conectar();
            String sql = "insert into venta (fecha_venta, tienda_id, ci_vendedor, ci_cliente) values (?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, venta.getFecha());
            ps.setString(2, Integer.toString(venta.getTienda_id()));
            ps.setString(3, Integer.toString(venta.getCi_vendedor()));
            ps.setString(4, Integer.toString(venta.getCi_cliente()));

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "update venta set fecha_venta=?, tienda_id=?, ci_vendedor=?, ci_cliente=? where id_venta=? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, venta.getFecha());
            ps.setString(2, Integer.toString(venta.getTienda_id()));
            ps.setString(3, Integer.toString(venta.getCi_vendedor()));
            ps.setString(4, Integer.toString(venta.getCi_cliente()));
            ps.setInt(5, venta.getId_venta());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }       
    }

    @Override
    public void delete(int id_venta) throws Exception {
       try {
            this.conectar();
            String sql ="delete from venta where id_venta=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_venta);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;
        try {
            this.conectar();
            String sql = "select * from venta";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Venta>();

            while (rs.next()) {
                Venta ven = new Venta();
                ven.setIdventa(rs.getInt("id_venta"));   
                ven.setFecha(rs.getString("fecha_venta"));
                ven.setTienda_id(rs.getInt("tienda_id"));
                ven.setCi_vendedor(rs.getInt("ci_vendedor"));
                ven.setCi_cliente(rs.getInt("ci_cliente"));

                lista.add(ven);
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
    public Venta getByCi(int id_venta) throws Exception {
        Venta ven = new Venta();
        try {
            this.conectar();
            String sql = "select * from venta where id_venta=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_venta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ven.setIdventa(rs.getInt("id_venta"));
                ven.setFecha(rs.getString("fecha_venta"));
                ven.setTienda_id(rs.getInt("tienda_id"));
                ven.setCi_vendedor(rs.getInt("ci_vendedor"));
                ven.setCi_cliente(rs.getInt("ci_cliente"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ven;
    }
}
