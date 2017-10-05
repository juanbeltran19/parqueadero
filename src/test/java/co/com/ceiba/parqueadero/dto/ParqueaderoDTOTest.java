package co.com.ceiba.parqueadero.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.dao.AutomovilDAO;
import co.com.ceiba.parqueadero.dto.ParqueaderoDTO;

public class ParqueaderoDTOTest {

	private static ParqueaderoDTO dto;
	private static AutomovilDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dto = new ParqueaderoDTO();
		dao = new AutomovilDAO();
	}

	@Test
	public void validarCantidadAutomovilTest() {
		assertFalse("Caso1 validarCantidadAutomovil",  dto.validarCantidadAutomovil(dao.getCantidadCarros("CARRO"), dao.getCantidadMotos("MOTO")));
	}

	@Test
	public void ValidarCantidadAutomovilTest() {
		assertTrue("Caso1 validarCantidadAutomovil",  dto.validarCantidadAutomovil(20, 10));
	}	
	
	@Test
	public void validarIngresoAutomovilTest() throws Exception {
		assertFalse("Caso 1: ", dto.validarIngresoAutomovil("ABC147", "10/05/2017") );
	}	
	
	@Test
	public void ValidarIngresoAutomovilTest() throws Exception{
		assertTrue("Caso 2: ", dto.validarIngresoAutomovil("ABC147", "02/10/2017") );
	}		
		
}
