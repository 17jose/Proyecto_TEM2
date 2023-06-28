package com.emergentes.DAO;

import com.emergentes.modelo.Categoria;
import java.util.List;

public interface CategoriaDAO {

    public void insert(Categoria categoria) throws Exception;

    public void update(Categoria categoria) throws Exception;

    public void delete(int categoria_id) throws Exception;

    public List<Categoria> getAll() throws Exception;

    public Categoria getByCi(int ci) throws Exception;
}
