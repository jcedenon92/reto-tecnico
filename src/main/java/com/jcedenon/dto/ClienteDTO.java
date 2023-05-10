package com.jcedenon.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteDTO {

    @Size(min = 11, max = 11, message = "El RUC debe tener 11 caracteres")
    private String ruc;

    private String razonSocial;

    private String estado;

    private String direccion;

    private String ubigeo;

    private String departamento;

    private String provincia;

    private String distrito;
}
