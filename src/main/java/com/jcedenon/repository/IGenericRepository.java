package com.jcedenon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interfaz generica para escalabilidad de los repositorios
 * @param <T> Entidad
 * @param <ID> Tipo de dato del ID de la entidad
 */
@NoRepositoryBean
public interface IGenericRepository<T, ID> extends JpaRepository<T, ID> {
}
