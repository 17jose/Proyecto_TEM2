package com.emergentes.DAO;

import com.emergentes.modelo.Orden;
import java.util.List;

public interface OrdenDAO {
    public void insert(Orden orden)throws Exception;
    public void update(Orden orden)throws Exception;
    public void delete(int ci)throws Exception;
    public List<Orden> getAll() throws Exception;
    public Orden getByCi(int ci)throws Exception;
}