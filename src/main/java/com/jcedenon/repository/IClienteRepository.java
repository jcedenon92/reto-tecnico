package com.jcedenon.repository;

import com.jcedenon.model.Cliente;

/**
 * Interfaz para el repositorio de Cliente
 */
public interface IClienteRepository extends IGenericRepository<Cliente, String>{

    boolean existsByRuc(String ruc);
}
