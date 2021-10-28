package ec.gob.educacion.rest.sellobt;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.model.sellobt.PenEncuesta;
import ec.gob.educacion.model.sellobt.PenEstudiante;
import ec.gob.educacion.sellobt.dto.EncuestaDTO;
import ec.gob.educacion.service.sellobt.EncuestaService;
import ec.gob.educacion.service.sellobt.EstudianteService;



/**
 * Rest para el manejo de encuestado
 * 
 * @author Belen Changoluisa
 *
 */
@RestController
@RequestMapping("private/")
public class EncuestaRest {
	
	@Autowired
	private EncuestaService encuestaService;	
	
	@Autowired
	private EstudianteService estudianteService;
	
	
	/**
	 * REST para guardar o actualizar encuesta
	 * 
	 * @return encuesta a guardar
	 */
	@PostMapping(value = "guardarEncuesta")
	public ResponseGenerico<String> guardarEncuesta(@RequestBody EncuestaDTO encuestaDTO){
		PenEncuesta encuesta = new PenEncuesta();
		encuesta.setEncCodigo(encuestaDTO.getEncCodigo());
		encuesta.setEncEstado(encuestaDTO.getEncEstado());
		encuesta.setEncFechaCreacion(new Date());
		encuesta.setPreCodigo(encuestaDTO.getPreCodigo());
		encuesta.setResCodigo(encuestaDTO.getResCodigo());
		encuesta.setUsuCodigo(encuestaDTO.getUsuCodigo());
		PenEstudiante penEncuesta = estudianteService.buscarEstudiantePorCodigo(encuestaDTO.getEstCodigo());
		encuesta.setPenEstudiante(penEncuesta);
		encuestaService.guardarPenEncuesta(encuesta) ;
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setMensaje("OK");
		return response;
	}
	

}
