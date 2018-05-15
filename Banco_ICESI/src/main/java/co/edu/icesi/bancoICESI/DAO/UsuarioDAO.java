package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.Usuario;

@Repository
@Scope("singleton")
public class UsuarioDAO implements IUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);

	}

	@Override
	public void update(Usuario usuario) {
		entityManager.merge(usuario);

	}

	@Override
	public void delete(Usuario usuario) {
		entityManager.remove(usuario);

	}

	@Override
	public Usuario findById(Long idUsuario) {
		return entityManager.find(Usuario.class, idUsuario);
	}

	@Override
	public List<Usuario> findAll() {
		Query query = entityManager.createNamedQuery("Usuario.findAll");
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

}
