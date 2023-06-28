package com.emergentes.DAO;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimple extends conexionBD implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "insert into cliente (ci_cliente, nombre_cliente, apellidos_cliente, celular) values (?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(cliente.getCi()));
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCelular());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "update cliente set nombre_cliente=?, apellidos_cliente=?, celular=? where ci_cliente=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getCelular());
            ps.setInt(4, cliente.getCi());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int ci) throws Exception {
        try {
            this.conectar();
            String sql ="delete from cliente where ci_cliente = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ci);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            String sql = "select * from cliente";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Cliente>();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCi(rs.getInt("ci_cliente"));
                cli.setNombre(rs.getString("nombre_cliente"));
                cli.setApellidos(rs.getString("apellidos_cliente"));
                cli.setCelular(rs.getString("celular"));

                lista.add(cli);
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
    public Cliente getByCi(int ci) throws Exception {
        Cliente cli = new Cliente();
        try {
            this.conectar();
            String sql = "select * from cliente where ci_cliente=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ci);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cli.setCi(rs.getInt("ci_cliente"));
                cli.setNombre(rs.getString("nombre_cliente"));
                cli.setApellidos(rs.getString("apellidos_cliente"));
                cli.setCelular(rs.getString("celular"));
                cli.setId(Integer.parseInt(rs.getString("id_Cliente")));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }
}
