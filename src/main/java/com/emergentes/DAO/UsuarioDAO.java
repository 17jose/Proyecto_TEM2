package com.emergentes.DAO;

import com.emergentes.modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {

    public void insert(Usuario usuario) throws Exception;

    public void update(Usuario usuario) throws Exception;

    public void delete(int id) throws Exception;

    public List<Usuario> getAll() throws Exception;

    public Usuario getByCi(int marca_id) throws Exception;
}
