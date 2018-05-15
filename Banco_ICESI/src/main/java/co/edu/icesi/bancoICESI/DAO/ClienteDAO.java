package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.Cliente;

@Repository
@Scope("singleton")
public class ClienteDAO implements IClienteDAO {
	
	// Fields
	// ===========================================================================================
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// Services
	// ===========================================================================================
	
	@Override
	public void save(Cliente cliente) {
		entityManager.persist(cliente);

	}

	@Override
	public void update(Cliente cliente) {
		entityManager.merge(cliente);

	}

	@Override
	public void delete(Cliente cliente) {
		entityManager.remove(cliente);

	}

	@Override
	public Cliente findById(Long idCliente) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Cliente.class, idCliente);
	}

	@Override
	public List<Cliente> findAll() {
		Query query = entityManager.createNamedQuery("Cliente.findAll");
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}

}
