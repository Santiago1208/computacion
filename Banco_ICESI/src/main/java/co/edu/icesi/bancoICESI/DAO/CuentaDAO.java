package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.bancoICESI.modelo.Cuenta;

@Repository
@Scope("singleton")
public class CuentaDAO implements ICuentaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Cuenta cuenta) {
		entityManager.persist(cuenta);

	}

	@Override
	public void update(Cuenta cuenta) {
		entityManager.merge(cuenta);

	}

	@Override
	public void delete(Cuenta cuenta) {
		entityManager.remove(cuenta);

	}

	@Override
	public Cuenta findById(Long idCuenta) {
		return entityManager.find(Cuenta.class, idCuenta);
	}

	@Override
	public List<Cuenta> findAll() {
		Query query = entityManager.createNamedQuery("Cuenta.findAll");
		List<Cuenta> cuentas = query.getResultList();
		return cuentas;
	}

}
