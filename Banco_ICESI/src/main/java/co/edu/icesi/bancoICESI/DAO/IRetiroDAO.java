package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Retiro;

public interface IRetiroDAO {
	
	public void save(Retiro retiro);
	
	public void update(Retiro retiro);
	
	public void delete(Retiro retiro);
	
	public Retiro findById(Long idRetiro);
	
	public List<Retiro> findAll();

}
