package com.emergentes.DAO;

import com.emergentes.modelo.Marca;
import java.util.List;

public interface MarcaDAO {
  
    public void insert(Marca marca) throws Exception;

    public void update(Marca marca) throws Exception;

    public void delete(int marca_id) throws Exception;

    public List<Marca> getAll() throws Exception;

    public Marca getByCi(int marca_id) throws Exception;
}
