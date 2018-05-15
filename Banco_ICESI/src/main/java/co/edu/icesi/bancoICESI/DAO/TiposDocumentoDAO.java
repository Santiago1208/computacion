package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.TiposDocumento;

@Repository
@Scope("singleton")
public class TiposDocumentoDAO implements ITiposDocumentoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TiposDocumento tipoDocumento) {
		entityManager.persist(tipoDocumento);

	}

	@Override
	public void update(TiposDocumento tipoDocumento) {
		entityManager.merge(tipoDocumento);

	}

	@Override
	public void delete(TiposDocumento tipoDocumento) {
		entityManager.remove(tipoDocumento);

	}

	@Override
	public TiposDocumento findById(Long idTiposDocumento) {
		return entityManager.find(TiposDocumento.class, idTiposDocumento);
	}

	@Override
	public List<TiposDocumento> findAll() {
		Query query = entityManager.createNamedQuery("TiposDocumento.findAll");
		List<TiposDocumento> tiposDocumentos = query.getResultList();
		return tiposDocumentos;
	}

}
