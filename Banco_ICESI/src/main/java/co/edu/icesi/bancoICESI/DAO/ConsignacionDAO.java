package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.Consignacion;
import co.edu.icesi.bancoICESI.modelo.ConsignacionPK;

@Repository
@Scope("singleton")
public class ConsignacionDAO implements IConsignacionDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Consignacion consignacion) {
		entityManager.persist(consignacion);

	}

	@Override
	public void update(Consignacion consignacion) {
		entityManager.merge(consignacion);

	}

	@Override
	public void delete(Consignacion consignacion) {
		entityManager.remove(consignacion);

	}

	@Override
	public Consignacion findById(Long idConsignacion) {
		ConsignacionPK primaryKey = entityManager.find(ConsignacionPK.class, idConsignacion);
		return entityManager.find(Consignacion.class, primaryKey);
	}

	@Override
	public List<Consignacion> findAll() {
		Query query = entityManager.createNamedQuery("Consignacion.findAll");
		List<Consignacion> consignaciones = query.getResultList();
		return consignaciones;
	}

}
