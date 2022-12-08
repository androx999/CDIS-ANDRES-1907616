package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CDISBANCOAABC.springboot.app.models.entity.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository("empleadoDao")
public class EmpleadoDaoImpl implements IEmpleadoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Empleado> findAll(){
		
		return em.createQuery("from Empleado").getResultList();
	}
	
	    @Override
	    @Transactional
	    public void save(Empleado empleado) {
	    	if(empleado.getId() != null && empleado.getId() > 0) {
	    		em.merge(empleado);
	    	}else {
	    		em.persist(empleado);
	    	}
	    }

}
