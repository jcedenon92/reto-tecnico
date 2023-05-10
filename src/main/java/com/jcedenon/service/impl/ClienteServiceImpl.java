package com.jcedenon.service.impl;

import com.jcedenon.model.Cliente;
import com.jcedenon.repository.IClienteRepository;
import com.jcedenon.repository.IGenericRepository;
import com.jcedenon.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio de Cliente
 * Hereda los metodos genericos de CRUDImpl
 * Implementa los metodos especificos de IClienteService
 */
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CRUDImpl<Cliente, String> implements IClienteService {

    private final IClienteRepository repo;

    @Override
    protected IGenericRepository<Cliente, String> getRepo() {
        return repo;
    }

    @Override
    public boolean existsByRuc(String ruc) {
        return repo.existsByRuc(ruc);
    }
}
