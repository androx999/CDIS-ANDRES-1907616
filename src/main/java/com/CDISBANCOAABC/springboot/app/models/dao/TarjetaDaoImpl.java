package com.CDISBANCOAABC.springboot.app.models.dao;

import java.util.List;

import org.hibernate.exception.DataException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CDISBANCOAABC.springboot.app.errors.DataBaseBancoException;
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
	    public void save(Tarjeta tarjeta) throws DataBaseBancoException{ 
	    	if(tarjeta.getId() != null && tarjeta.getId() > 0) {
	    		try{
	    			em.merge(tarjeta);
	    		} catch(DataException e) {
	    			throw new DataBaseBancoException();
	    		}
	    	}else {
	    		try {
	    		em.persist(tarjeta);
	    	}catch(DataException e) {
    			throw new DataBaseBancoException();
    		  }
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

		@Override
		public List<Tarjeta> findByCuentaId(String term) {
			// TODO Auto-generated method stub
			return null;
		}

}
