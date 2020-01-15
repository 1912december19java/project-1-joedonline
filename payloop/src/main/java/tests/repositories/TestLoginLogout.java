package tests.repositories;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import repositories.ConnectionManager;

public class TestLoginLogout {
	
	Connection connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		connection = ConnectionManager.getConnection();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmployeeCanLogin() {
		
		System.out.println("[testEmployeeCanLogin] connection " + connection);
		
		fail("FAIL FIRST");
		
	}

}
