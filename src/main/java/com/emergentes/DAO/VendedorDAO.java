package com.emergentes.DAO;

import com.emergentes.modelo.Vendedor;
import java.util.List;

public interface VendedorDAO {
  
    public void insert(Vendedor vendedor) throws Exception;

    public void update(Vendedor vendedor) throws Exception;

    public void delete(int id) throws Exception;

    public List<Vendedor> getAll() throws Exception;

    public Vendedor getByCi(int marca_id) throws Exception;
}