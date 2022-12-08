package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import com.CDISBANCOAABC.springboot.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);

}
