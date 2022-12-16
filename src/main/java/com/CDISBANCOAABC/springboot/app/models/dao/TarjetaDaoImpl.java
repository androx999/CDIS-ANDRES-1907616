package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CDISBANCOAABC.springboot.app.models.entity.Tarjeta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository("tarjetaDao")
public class TarjetaDaoImpl implements ITarjetaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Tarjeta> findAll(){
		
		return em.createQuery("from Tarjeta").getResultList();
	}
	
	    @Override
	    @Transactional
	    public void save(Tarjeta tarjeta) {
	    	if(tarjeta.getId() != null && tarjeta.getId() > 0) {
	    		em.merge(tarjeta);
	    	}else {
	    		em.persist(tarjeta);
	    	}
	    }

		@Override
		@Transactional(readOnly = true)
		public Tarjeta findOne(Long id) {
			// TODO Auto-generated method stub
			return em.find(Tarjeta.class, id);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			// TODO Auto-generated method stub
			em.remove(findOne(id));
		}

}
