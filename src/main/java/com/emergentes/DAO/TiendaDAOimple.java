package com.emergentes.DAO;

import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Tienda;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaDAOimple extends conexionBD implements TiendaDAO{

    @Override
    public void insert(Tienda tienda) throws Exception {
        try {
            this.conectar();
            String sql = "insert into tienda (direccion, ciudad, telefono) values (?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setString(1, tienda.getDireccion());
            ps.setString(2, tienda.getCiudad());
            ps.setInt(3, tienda.getTelefono());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Tienda tienda) throws Exception {
        try {
            this.conectar();
            String sql = "update tienda set direccion=?, ciudad=?, telefono=? where id_tienda=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tienda.getDireccion());
            ps.setString(2, tienda.getCiudad());
            ps.setInt(3, tienda.getTelefono());
            ps.setInt(4, tienda.getId_tienda());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_tienda) throws Exception {
        try {
            this.conectar();
            String sql ="delete from tienda where id_tienda = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_tienda);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Tienda> getAll() throws Exception {
        List<Tienda> lista = null;
        try {
            this.conectar();
            String sql = "select * from tienda";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Tienda>();

            while (rs.next()) {
                Tienda t = new Tienda();
                t.setId_tienda(rs.getInt("id_tienda"));
                t.setDireccion(rs.getString("direccion"));
                t.setCiudad(rs.getString("ciudad"));
                t.setTelefono(rs.getInt("telefono"));
                
                lista.add(t);
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
    public Tienda getByCi(int ci) throws Exception {
        Tienda t = new Tienda();
        try {
            this.conectar();
            String sql = "select * from tienda where id_tienda=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ci);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t.setId_tienda(rs.getInt("id_tienda"));
                t.setDireccion(rs.getString("direccion"));
                t.setCiudad(rs.getString("ciudad"));
                t.setTelefono(rs.getInt("telefono"));
                
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return t;
    }}