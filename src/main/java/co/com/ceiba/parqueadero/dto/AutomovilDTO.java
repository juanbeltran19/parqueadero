package co.com.ceiba.parqueadero.dto;

public class AutomovilDTO {
		private String placa;
		private String tipo;
		private String fechaIngreso;
		public AutomovilDTO() {}
		public AutomovilDTO(String placa, String tipo, String fechaIngreso) {
			this.placa = placa;
			this.tipo = tipo;
			this.fechaIngreso = fechaIngreso;
		}
		public String getPlaca() {
			return placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getFechaIngreso() {
			return fechaIngreso;
		}
		public void setFechaIngreso(String fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}	
}

