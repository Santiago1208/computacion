package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Cuenta;

public interface ICuentaDAO {
	
	public void save(Cuenta cuenta);
	
	public void update(Cuenta cuenta);
	
	public void delete(Cuenta cuenta);
	
	public Cuenta findById(Long idCuenta);
	
	public List<Cuenta> findAll();

}
