package com.emergentes.DAO;

import com.emergentes.modelo.Vendedor;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAOimple extends conexionBD implements VendedorDAO {

    @Override
    public void insert(Vendedor vendedor) throws Exception {
        try {
            this.conectar();
            String sql = "insert into vendedor (ci_vendedor, nombre_vendedor, apellido_paterno, apellido_materno, celular, id_tienda) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, vendedor.getCi_vendedor());
            ps.setString(2, vendedor.getNombre_vendedor());
            ps.setString(3, vendedor.getApellido_paterno());
            ps.setString(4, vendedor.getApellido_materno());
            ps.setInt(5, vendedor.getCelular());
            ps.setInt(6, vendedor.getId_tienda());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Vendedor vendedor) throws Exception {
        try {
            this.conectar();
            String sql = "update vendedor set ci_vendedor=?, nombre_vendedor=?, apellido_paterno=?, apellido_materno=?, celular=?, id_tienda=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, vendedor.getCi_vendedor());
            ps.setString(2, vendedor.getNombre_vendedor());
            ps.setString(3, vendedor.getApellido_paterno());
            ps.setString(4, vendedor.getApellido_materno());
            ps.setInt(5, vendedor.getCelular());
            ps.setInt(6, vendedor.getId_tienda());
            ps.setInt(7, vendedor.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from vendedor where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Vendedor> getAll() throws Exception {
        List<Vendedor> lista = null;
        try {
            this.conectar();
            String sql = "select * from vendedor";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Vendedor>();

            while (rs.next()) {
                Vendedor ven = new Vendedor();
                ven.setId(rs.getInt("id"));
                ven.setCi_vendedor(rs.getInt("ci_vendedor"));
                ven.setNombre_vendedor(rs.getString("nombre_vendedor"));
                ven.setApellido_paterno(rs.getString("apellido_paterno"));
                ven.setApellido_materno(rs.getString("apellido_materno"));
                ven.setCelular(rs.getInt("celular"));
                ven.setId_tienda(rs.getInt("id_tienda"));

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
    public Vendedor getByCi(int id) throws Exception {
        Vendedor ven = new Vendedor();
        try {
            this.conectar();
            String sql = "select * from vendedor where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ven.setCi_vendedor(rs.getInt("ci_vendedor"));
                ven.setNombre_vendedor(rs.getString("nombre_vendedor"));
                ven.setApellido_paterno(rs.getString("apellido_paterno"));
                ven.setApellido_materno(rs.getString("apellido_materno"));
                ven.setCelular(rs.getInt("celular"));
                ven.setId_tienda(rs.getInt("id_tienda"));
                ven.setId(rs.getInt("id"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ven;
    }
}
