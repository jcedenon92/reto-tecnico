package com.jcedenon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Clase para el modelo de Cliente
 * @Data: Anotacion de Lombok para generar los getters, setters, toString, equals y hashcode
 * @AllArgsConstructor: Anotacion de Lombok para generar un constructor con todos los argumentos
 * @NoArgsConstructor: Anotacion de Lombok para generar un constructor sin argumentos
 * @Entity: Anotacion de JPA para indicar que es una entidad
 * @EqualsAndHashCode: Anotacion de Lombok para generar el metodo equals y hashcode
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @Column(name = "ruc", length = 11, unique = true)
    private String ruc;

    @Column(name = "razon_social", length = 250, nullable = false)
    private String razonSocial;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "ubigeo", length = 6, nullable = false)
    private String ubigeo;

    @Column(name = "departamento", length = 50, nullable = false)
    private String departamento;

    @Column(name = "provincia", length = 50, nullable = false)
    private String provincia;

    @Column(name = "distrito", length = 50, nullable = false)
    private String distrito;

    /*@PrePersist
    public void prePersist() {
        this.direccion = direccion.toUpperCase().concat("      " + departamento.toUpperCase() + "  " + provincia.toUpperCase() + "  " + distrito.toUpperCase());
    }*/
}
