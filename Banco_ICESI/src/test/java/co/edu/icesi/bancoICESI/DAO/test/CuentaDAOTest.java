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

import co.edu.icesi.bancoICESI.DAO.CuentaDAO;
import co.edu.icesi.bancoICESI.modelo.Cuenta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class CuentaDAOTest {
	
	// Constants
	// ================================================================================================
	
	public final static Logger log = LoggerFactory.getLogger(ClientesDAOTest.class);
	
	// Fields
	// ================================================================================================
	
	@Autowired
	private CuentaDAO cuentaDAO;

	// Test Cases
	// ================================================================================================
	
	@Test
	public void saveTest() {
		
	}
	
	@Test
	public void updateTest() {
		
	}
	
	@Test
	public void deleteTest() {
		
	}
	
	@Test
	public void findTest() {
		
	}
	
	private void print(Cuenta cuenta) {
		
	}

}
