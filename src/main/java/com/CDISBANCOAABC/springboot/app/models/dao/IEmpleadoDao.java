package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import com.CDISBANCOAABC.springboot.app.models.entity.Empleado;

public interface IEmpleadoDao {

	public List<Empleado> findAll();
	
	public void save(Empleado empleado);
}
