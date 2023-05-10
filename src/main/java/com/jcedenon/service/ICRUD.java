package com.jcedenon.service;

import java.util.List;

/**
 * Interfaz generica para escalabilidad de los servicios
 * Metodos genericos de CRUD (Create, Read, Update, Delete)
 * @param <T>
 * @param <ID>
 */
public interface ICRUD<T, ID> {

    T save(T t);

    T update(T t, ID id);

    List<T> findAll();

    T findById(ID id);

    void deleteById(ID id);
}
