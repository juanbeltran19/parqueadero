package co.com.ceiba.parqueadero.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import co.com.ceiba.parqueadero.dto.AutomovilDTO;
import co.com.ceiba.parqueadero.dto.ParqueaderoDTO;
import co.com.ceiba.parqueadero.dao.AutomovilDAO; 

@Path("/")
public class ParqueaderoWS{
  
	private AutomovilDAO dao;
	private ParqueaderoDTO parqueaderoDTO;
	
	public ParqueaderoWS() {
	}
 
	@GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Prueba OK Rest</h1></body></html>";
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("buscar/todos")
	public  List<AutomovilDTO> consultarAutomoviles(){	
		dao = new AutomovilDAO();
		return dao.getAutomoviles();  		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("buscar/{placa}")
	public  List<AutomovilDTO> consultarAutomoviles(@PathParam("placa") String param){
		dao = new AutomovilDAO();
		return dao.getAutomovil(param);  		
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String registrarAutomoviles(AutomovilDTO data){
		 dao = new AutomovilDAO();	
		 parqueaderoDTO = new ParqueaderoDTO();
		 if( parqueaderoDTO.validarCantidadAutomovil( dao.getCantidadCarros("Carro") , dao.getCantidadMotos("Moto")) 
				 && parqueaderoDTO.validarIngresoAutomovil(data.getPlaca(), data.getFechaIngreso()) ) {			
		 }
		return "";
	}	
}

