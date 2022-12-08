package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import com.CDISBANCOAABC.springboot.app.models.entity.Banco;

public interface IBancoDao {
	
	public List<Banco> findAll();
	
	public void save(Banco banco);

}
