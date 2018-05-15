package co.edu.icesi.bancoICESI.DAO.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.bancoICESI.DAO.ClienteDAO;
import co.edu.icesi.bancoICESI.DAO.TiposDocumentoDAO;
import co.edu.icesi.bancoICESI.modelo.Cliente;
import co.edu.icesi.bancoICESI.modelo.TiposDocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class ClientesDAOTest {
	
	// Constants
	// ================================================================================================
	
	public final static Logger log = LoggerFactory.getLogger(ClientesDAOTest.class);
	
	public final static Long non_existentID = 851234L;
	
	public final static Long existentID = 801234L;
	
	public final static Long existentIDType = 10L;
	
	// Fields
	// ================================================================================================
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private TiposDocumentoDAO tiposDocumentosDAO;

	// Test Cases
	// ================================================================================================
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {
		log.info("Save test has been started...");
		
		// Finding the new client
		Cliente client = clienteDAO.findById(non_existentID);
		assertNull("The client " + non_existentID + " shouldn't exist!", client);
		
		// The client don't exists, so then we find an existent ID type for the new client
		TiposDocumento IDType = tiposDocumentosDAO.findById(existentIDType);
		assertNotNull("The ID Type " + existentID + " should exist!", IDType);
		
		// The ID Type exists, so we can create the new client
		client = new Cliente();
		client.setCliId(non_existentID);
		client.setCliNombre("Santiago Restrepo Prado");
		client.setCliDireccion("CARRERA 77 # 3-56");
		client.setCliTelefono("324-1528");
		client.setTiposDocumento(IDType);
		client.setCliMail("sanpra1208@gmail.com");
		client.setCliHabilitado("S");
		
		// We persist the new client in the database
		clienteDAO.save(client);
		
		// We make sure the new client was stored in the database
		client = clienteDAO.findById(non_existentID);
		assertNotNull("The new client weren't stored in the database", client);
		
		// The new client was stored, we can print it
		print(client);
		
		log.info("Save test has finished");
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTest() {
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTest() {
		
	}
	
	@Test
	@Transactional(readOnly = true)
	public void findTest() {
		
	}
	
	private void print(Cliente cliente) {
		log.info("Client ID: " + cliente.getCliId());
		log.info("Client Name: " + cliente.getCliNombre());
		log.info("Client Address: " + cliente.getCliDireccion());
		log.info("Client Enabled: " + cliente.getCliHabilitado());
		log.info("Client Email: " + cliente.getCliMail());
		log.info("Client Phone Number: " + cliente.getCliTelefono());
		log.info("Client ID Type: " + cliente.getTiposDocumento().getTdocCodigo());
	}

}
