package co.com.ceiba.parqueadero.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class AutomovilDAOTest {

	private static AutomovilDAO dao;
		
	@Before
	public void before() throws Exception {
		dao = new AutomovilDAO();
	}	
		
	@Test
	public void ConsultarAutomovilesTest() {
		Assert.assertEquals(2, dao.getAutomoviles().size());
	}
		
	@Test
	public void ConsultarAutomovilTest() {
		Assert.assertEquals(1, dao.getAutomovil("OYU32B").size());
	}	

	@Test
	public void ConsultarAutomovilnoExisteTest() {
		Assert.assertEquals(0, dao.getAutomovil("ABC123").size());
	}		

}
