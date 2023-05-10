package com.jcedenon.controller;

import com.jcedenon.dto.ClienteDTO;
import com.jcedenon.exception.ModelNotFoundException;
import com.jcedenon.model.Cliente;
import com.jcedenon.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.jcedenon.utils.GlobalConstants.API_CLIENTES;

@RestController
@RequestMapping(API_CLIENTES)
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    /**
     * DEVUELVE EL CLIENTE POR RUC ENVIADO COMO PARAMETRO
     * VALIDACIÓN MANEJANDO LA EXCEPCIÓN ModelNotFoundException
     * @param ruc
     * @return
     */
    @GetMapping()
    public ResponseEntity<ClienteDTO> clientePorRuc(@RequestParam("ruc") String ruc){
        if (ruc.length() < 11) {
            throw new ModelNotFoundException("RUC invalido");
        }
        if (!service.existsByRuc(ruc)) {
            throw new ModelNotFoundException("RUC no encontrado");
        }
        ClienteDTO dto = convertToDto(service.findById(ruc));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * CREANDO UN NUEVO CLIENTE EN LA BASE DE DATOS Y DEVOLVIENDO LA URI DE LA NUEVA ENTIDAD CREADA
     * VALIDANDO SI EXISTE O NO EL RUC EN LA BASE DE DATOS Y MANEJANDO LA EXCEPCIÓN ModelNotFoundException
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> save(@Valid @RequestBody ClienteDTO dto){
        if(service.existsByRuc(dto.getRuc())){
            throw new ModelNotFoundException("El RUC ya existe");
        }
        Cliente cliente = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ruc}").buildAndExpand(cliente.getRuc()).toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     * CONVIRTIENDO DE DTO A ENTITY
     * @param patientDTO
     * @return
     */
    private Cliente convertToEntity(ClienteDTO patientDTO){
        return mapper.map(patientDTO, Cliente.class);
    }

    /**
     * CONVIRTIENDO DE ENTITY A DTO
     * @param patient
     * @return
     */
    private ClienteDTO convertToDto(Cliente patient){
        return mapper.map(patient, ClienteDTO.class);
    }
}
