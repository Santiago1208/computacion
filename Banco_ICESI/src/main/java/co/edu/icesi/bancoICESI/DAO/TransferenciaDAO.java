package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.Transferencia;

@Repository
@Scope("singleton")
public class TransferenciaDAO implements ITransferenciaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Transferencia transferencia) {
		entityManager.persist(transferencia);

	}

	@Override
	public void update(Transferencia transferencia) {
		entityManager.merge(transferencia);

	}

	@Override
	public void delete(Transferencia transferencia) {
		entityManager.remove(transferencia);

	}

	@Override
	public Transferencia findById(Long idTransferencia) {
		return entityManager.find(Transferencia.class, idTransferencia);
	}

	@Override
	public List<Transferencia> findAll() {
		Query query = entityManager.createNamedQuery("Transferencia.findAll");
		List<Transferencia> transferencias = query.getResultList();
		return transferencias;
	}

}
