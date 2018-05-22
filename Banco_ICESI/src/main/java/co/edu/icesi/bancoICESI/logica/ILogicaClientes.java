package co.edu.icesi.bancoICESI.logica;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Cliente;

public interface ILogicaClientes {
	
	public void save(Cliente cliente) throws Exception;
	
	public void update(Cliente cliente) throws Exception;
	
	public void delete(Cliente cliente) throws Exception;
	
	public Cliente findById(Long idCliente) throws Exception;
	
	public List<Cliente> findAll();

}
