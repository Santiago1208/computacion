package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.Retiro;
import co.edu.icesi.bancoICESI.modelo.RetiroPK;

@Repository
@Scope("singleton")
public class RetiroDAO implements IRetiroDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Retiro retiro) {
		entityManager.persist(retiro);

	}

	@Override
	public void update(Retiro retiro) {
		entityManager.merge(retiro);

	}

	@Override
	public void delete(Retiro retiro) {
		entityManager.remove(retiro);

	}

	@Override
	public Retiro findById(Long idRetiro) {
		RetiroPK primaryKey = entityManager.find(RetiroPK.class, idRetiro);
		return entityManager.find(Retiro.class, primaryKey);
	}

	@Override
	public List<Retiro> findAll() {
		Query query = entityManager.createNamedQuery("Retiro.findAll");
		List<Retiro> retiros = query.getResultList();
		return retiros;
	}

}
