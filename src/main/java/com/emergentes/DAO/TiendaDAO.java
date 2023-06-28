package com.emergentes.DAO;

import com.emergentes.modelo.Tienda;
import java.util.List;

public interface TiendaDAO {

    public void insert(Tienda tienda) throws Exception;

    public void update(Tienda tienda) throws Exception;

    public void delete(int categoria_id) throws Exception;

    public List<Tienda> getAll() throws Exception;

    public Tienda getByCi(int ci) throws Exception;
}
