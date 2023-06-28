package com.emergentes.DAO;

import com.emergentes.modelo.Venta;
import java.util.List;

public interface VentaDAO {
     public void insert(Venta venta)throws Exception;
    public void update(Venta venta)throws Exception;
    public void delete(int ci)throws Exception;
    public List<Venta> getAll() throws Exception;
    public Venta getByCi(int ci)throws Exception;
} 

