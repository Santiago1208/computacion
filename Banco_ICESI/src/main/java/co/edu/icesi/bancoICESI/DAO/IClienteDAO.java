package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Cliente;

public interface IClienteDAO {
	
	public void save(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public Cliente findById(Long idCliente);
	
	public List<Cliente> findAll();

}
