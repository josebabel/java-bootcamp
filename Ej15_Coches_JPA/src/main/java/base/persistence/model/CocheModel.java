package base.persistence.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import base.persistence.entity.Coche;
import base.persistence.model.interfaces.DAOCoche;

@Repository
public class CocheModel implements DAOCoche{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int create(Coche c) {
		em.persist(c);
		return c.getId();
	}

	@Override
	public Coche update(Coche c) {
		return em.merge(c);
	}

	@Override
	public int delete(int id) {
		Coche cAux = em.find(Coche.class, id);
		em.remove(cAux);
		return cAux.getId();
	}

	@Override
	public Coche getOne(int id) {
		return em.find(Coche.class, id);
	}

	@Override
	public List<Coche> getAll() {
		List<Coche> listCoches = em.createQuery("FROM Coche c").getResultList();
		return listCoches;
	}

}
