package com.jcedenon.service;

import com.jcedenon.model.Cliente;

/**
 * Interfaz para el servicio de Cliente
 * Hereda los metodos genericos de ICRUD
 */
public interface IClienteService extends ICRUD<Cliente, String>{

    boolean existsByRuc(String ruc);
}
