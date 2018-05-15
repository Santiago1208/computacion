package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Transferencia;

public interface ITransferenciaDAO {
	
	public void save(Transferencia transferencia);
	
	public void update(Transferencia transferencia);
	
	public void delete(Transferencia transferencia);
	
	public Transferencia findById(Long idTransferencia);
	
	public List<Transferencia> findAll();

}
