package co.edu.icesi.bancoICESI.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.icesi.bancoICESI.DAO.IClienteDAO;
import co.edu.icesi.bancoICESI.DAO.ITiposDocumentoDAO;
import co.edu.icesi.bancoICESI.modelo.Cliente;

@Service
@Scope("singleton")
public class LogicaClientes implements ILogicaClientes {
	
	// Atributos
	// ===========================================================================================
	
	@Autowired
	private IClienteDAO clientesDAO;
	
	@Autowired
	private ITiposDocumentoDAO tiposDocumentosDAO;
	
	// Servicios
	// ===========================================================================================

	@Override
	public void save(Cliente cliente) throws Exception {
		
		// Validamos que el cliente no sea null
		if (cliente == null) {
			throw new Exception("El cliente que se va a guardar no puede ser null");
		}
		
		// Validamos que la identificación del cliente sea válida
		if (cliente.getCliId() <= 0) {
			throw new Exception("La identificación del cliente no es válida");
		}
		
		// Validamos que el nombre del cliente sea válido
		if (cliente.getCliNombre() == null || cliente.getCliNombre().trim().equals("")) {
			throw new Exception("El nombre del cliente no es válido");
		}
		
		// Validamos que la dirección del cliente sea válida
		if (cliente.getCliDireccion() == null || cliente.getCliDireccion().trim().equals("")) {
			throw new Exception("La dirección del cliente no es válida");
		}
		
		// Validamos que el telefono del cliente sea válido
		if (cliente.getCliTelefono() == null || cliente.getCliTelefono().trim().equals("")) {
			throw new Exception("El teléfono del cliente no es válido");
		}
		
		// Validamos que la identificación del cliente no exista en la base de datos
		Cliente otroCliente = clientesDAO.findById(cliente.getCliId());
		if (otroCliente != null) {
			throw new Exception("El cliente con identificacion " + cliente.getCliId() + " ya existe");
		}
		
		// Activamos al nuevo cliente
		cliente.setCliHabilitado("S");
		
		// Guardamos al nuevo cliente
		clientesDAO.save(cliente);
	}

	@Override
	public void update(Cliente cliente) throws Exception {
		// Validamos que el cliente no sea null
		if (cliente == null) {
			throw new Exception("El cliente que se va a guardar no puede ser null");
		}

		// Validamos que la identificación del cliente sea válida
		if (cliente.getCliId() <= 0) {
			throw new Exception("La identificación del cliente no es válida");
		}

		// Validamos que el nombre del cliente sea válido
		if (cliente.getCliNombre() == null || cliente.getCliNombre().trim().equals("")) {
			throw new Exception("El nombre del cliente no es válido");
		}

		// Validamos que la dirección del cliente sea válida
		if (cliente.getCliDireccion() == null || cliente.getCliDireccion().trim().equals("")) {
			throw new Exception("La dirección del cliente no es válida");
		}

		// Validamos que el telefono del cliente sea válido
		if (cliente.getCliTelefono() == null || cliente.getCliTelefono().trim().equals("")) {
			throw new Exception("El teléfono del cliente no es válido");
		}
	}

	@Override
	public void delete(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente findById(Long idCliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
