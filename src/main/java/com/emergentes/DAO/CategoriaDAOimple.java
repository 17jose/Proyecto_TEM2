package com.emergentes.DAO;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOimple extends conexionBD implements CategoriaDAO {

    @Override
    public void insert(Categoria categoria) throws Exception {
        try {
            this.conectar();
            String sql = "insert into categoria (categoria) values (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try {
            this.conectar();
            String sql = "update categoria set categoria=? where categoria_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.setInt(2, categoria.getCategoria_id());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int categoria_id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from categoria where categoria_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, categoria_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Categoria> getAll() throws Exception {
        List<Categoria> lista = null;
        try {
            this.conectar();
            String sql = "select * from categoria";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Categoria>();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCategoria_id(rs.getInt("categoria_id"));
                cat.setCategoria(rs.getString("categoria"));

                lista.add(cat);
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
    public Categoria getByCi(int categoria_id) throws Exception {
        Categoria cat = new Categoria();
        try {
            this.conectar();
            String sql = "select * from categoria where categoria_id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, categoria_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cat.setCategoria_id(rs.getInt("categoria_id"));
                cat.setCategoria(rs.getString("categoria"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cat;
    }
}
