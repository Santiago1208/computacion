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

import co.edu.icesi.bancoICESI.DAO.RetiroDAO;
import co.edu.icesi.bancoICESI.modelo.Retiro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class RetiroDAOTest {
	
	// Constants
	// ================================================================================================
	
	public final static Logger log = LoggerFactory.getLogger(ClientesDAOTest.class);
	
	// Fields
	// ================================================================================================
	
	@Autowired
	private RetiroDAO retiroDAO;

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
	
	private void print(Retiro retiro) {
		
	}

}
