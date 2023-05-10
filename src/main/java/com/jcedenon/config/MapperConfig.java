package com.jcedenon.config;

import com.jcedenon.dto.ClienteDTO;
import com.jcedenon.model.Cliente;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    /*@Bean("clientMapper")
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<ClienteDTO, Cliente> typeMap1 = mapper.createTypeMap(ClienteDTO.class, Cliente.class);
        typeMap1.addMapping(ClienteDTO::getRuc, (dest, v) -> dest.setRuc((String) v));
        typeMap1.addMapping(ClienteDTO::getRazonSocial, (dest, v) -> dest.setRazonSocial((String) v));
        typeMap1.addMapping(ClienteDTO::getEstado, (dest, v) -> dest.setEstado((String) v));
        typeMap1.addMapping(ClienteDTO::getDireccion, (dest, v) -> dest.setDireccion((String) v));
        typeMap1.addMapping(ClienteDTO::getUbigeo, (dest, v) -> dest.setUbigeo((String) v));
        typeMap1.addMapping(ClienteDTO::getDepartamento, (dest, v) -> dest.setDepartamento((String) v));
        typeMap1.addMapping(ClienteDTO::getProvincia, (dest, v) -> dest.setProvincia((String) v));
        typeMap1.addMapping(ClienteDTO::getDistrito, (dest, v) -> dest.setDistrito((String) v));

        return mapper;
    }*/

}
