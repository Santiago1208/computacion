package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.TiposUsuario;

@Repository
@Scope("singleton")
public class TiposUsuarioDAO implements ITiposUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TiposUsuario tipoUsuario) {
		entityManager.persist(tipoUsuario);

	}

	@Override
	public void update(TiposUsuario tipoUsuario) {
		entityManager.merge(tipoUsuario);

	}

	@Override
	public void delete(TiposUsuario tipoUsuario) {
		entityManager.remove(tipoUsuario);

	}

	@Override
	public TiposUsuario findById(Long idTipoUsuario) {
		return entityManager.find(TiposUsuario.class, idTipoUsuario);
	}

	@Override
	public List<TiposUsuario> findAll() {
		Query query = entityManager.createNamedQuery("TiposUsuario.findAll");
		List<TiposUsuario> tiposUsuarios = query.getResultList();
		return tiposUsuarios;
	}

}
