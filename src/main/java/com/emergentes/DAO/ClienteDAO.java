package com.emergentes.DAO;

import com.emergentes.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    public void insert(Cliente cliente)throws Exception;
    public void update(Cliente cliente)throws Exception;
    public void delete(int ci)throws Exception;
    public List<Cliente> getAll() throws Exception;
    public Cliente getByCi(int ci)throws Exception;
}