package com.emergentes.DAO;

import com.emergentes.modelo.Marca;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAOimple extends conexionBD implements MarcaDAO {

    @Override
    public void insert(Marca marca) throws Exception {
        try {
            this.conectar();
            String sql = "insert into marca (marca) values (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
                        
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Marca marca) throws Exception {
        try {
            this.conectar();
            String sql = "update marca set marca=? where marca_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
            ps.setInt(2, marca.getMarca_id());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int marca_id) throws Exception {
        try {
            this.conectar();
            String sql ="delete from marca where marca_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, marca_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Marca> getAll() throws Exception {
        List<Marca> lista = null;
        try {
            this.conectar();
            String sql = "select * from marca";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Marca>();

            while (rs.next()) {
                Marca mar = new Marca();
                mar.setMarca_id(rs.getInt("marca_id"));
                mar.setMarca(rs.getString("marca"));
                

                lista.add(mar);
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
    public Marca getByCi(int marca_id) throws Exception {
        Marca mar = new Marca();
        try {
            this.conectar();
            String sql = "select * from marca where marca_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, marca_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mar.setMarca_id(rs.getInt("marca_id"));
                mar.setMarca(rs.getString("marca"));
                
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return mar;
    }
}