package com.humbertoempresa.springboot.backend.apirest.models.services;

import com.humbertoempresa.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    //firmas de métodos
    public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);

}
