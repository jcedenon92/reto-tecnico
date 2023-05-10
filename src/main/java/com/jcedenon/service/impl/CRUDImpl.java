package com.jcedenon.service.impl;

import com.jcedenon.repository.IGenericRepository;
import com.jcedenon.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID>{

    protected abstract IGenericRepository<T,ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id).orElseThrow();
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow();
    }

    @Override
    public void deleteById(ID id) {
        getRepo().findById(id).orElseThrow();
        getRepo().deleteById(id);
    }
}
