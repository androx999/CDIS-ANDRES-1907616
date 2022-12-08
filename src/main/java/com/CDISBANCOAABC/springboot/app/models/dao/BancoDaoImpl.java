package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CDISBANCOAABC.springboot.app.models.entity.Banco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository("bancoDao")
public class BancoDaoImpl implements IBancoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Banco> findAll(){
		
		return em.createQuery("from Banco").getResultList();
	}
	
	    @Override
	    @Transactional
	    public void save(Banco banco) {
	    	if(banco.getId() != null && banco.getId() > 0) {
	    		em.merge(banco);
	    	}else {
	    		em.persist(banco);
	    	}
	    }

}
