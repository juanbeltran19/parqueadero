package co.com.ceiba.parqueadero.rest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import co.com.ceiba.parqueadero.dao.AutomovilDAO;

public class ParqueaderoWSTest {

	private static AutomovilDAO dao;
	
	@Before
	public void before() throws Exception {
		dao = new AutomovilDAO();
	}	
	
	@Test
	public void ConsultarAutomovilesTest() {
		Assert.assertEquals(2, dao.getAutomoviles().size());
	}
	
	
}
