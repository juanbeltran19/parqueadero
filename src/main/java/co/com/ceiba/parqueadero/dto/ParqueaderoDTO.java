package co.com.ceiba.parqueadero.dto;

import java.util.Calendar;

public class ParqueaderoDTO implements Tarifa{
	
	public boolean validarCantidadAutomovil(int cuentaCarros, int cuentaMotos) {
		boolean validaCantidad = false;
		if(CANTIDAD_CARRO<=cuentaCarros && CANTIDAD_MOTO<=cuentaMotos) {
			validaCantidad =  true;
		}
		return validaCantidad;
	}

	public boolean validarIngresoAutomovil(String placa, String fechaIngreso) {
		boolean validaIngreso = false;
		try {
			 Calendar c = Calendar.getInstance();
			 c.set(Integer.parseInt(fechaIngreso.substring(6,10)), 
				   Integer.parseInt(fechaIngreso.substring(3,5))-1, 
				   Integer.parseInt(fechaIngreso.substring(0,2)));
			 int dia =  c.get(Calendar.DAY_OF_WEEK);
			 if(("A".equals(placa.substring(0,1))) && (dia==Calendar.SUNDAY || dia==Calendar.MONDAY)) {
				 validaIngreso = true;
			 }
			return validaIngreso;
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}	
	
}
