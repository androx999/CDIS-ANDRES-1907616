package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CDISBANCOAABC.springboot.app.models.entity.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository("cuentaDao")
public class CuentaDaoImpl implements ICuentaDao {
	
	@PersistenceContext
	private EntityManager em;
	
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
	@Override
	public List<Cuenta> findAll() {
		return em.createQuery("from Cuenta").getResultList();
	}
    
    @Override
    @Transactional
    public void save(Cuenta cuenta) {
    	if(cuenta.getId() != null && cuenta.getId() > 0) {
    		em.merge(cuenta);
    	}else {
    		em.persist(cuenta);
    	}
    }
    

}
