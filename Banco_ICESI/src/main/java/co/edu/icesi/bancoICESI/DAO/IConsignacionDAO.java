package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Consignacion;

public interface IConsignacionDAO {
	
	public void save(Consignacion consignacion);
	
	public void update(Consignacion consignacion);
	
	public void delete(Consignacion consignacion);
	
	public Consignacion findById(Long idConsignacion);
	
	public List<Consignacion> findAll();

}
