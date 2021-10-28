package ec.gob.educacion.rest.sellobt;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.model.sellobt.SbtEmpresa;
import ec.gob.educacion.model.sellobt.SbtSectorEmpresa;
import ec.gob.educacion.sellobt.dto.SbtEmpresaDTO;
import ec.gob.educacion.service.sellobt.SbtEmpresaService;
import ec.gob.educacion.service.sellobt.SbtSectorEmpresaService;

/**
 * Rest para el manejo de empresas
 * 
 * @author jbrito - 20211022
 *
 */
@RestController
@RequestMapping("private/")
public class SbtEmpresaRest {
	
	@Autowired
	private SbtEmpresaService sbtEmpresaService;	
	@Autowired
	private SbtSectorEmpresaService sectorService;
	
	//Importante hacer la inyección de dependencia de JavaMailSender:
    @Autowired
    private JavaMailSender mailSender;
	
	/**
	 * Metodo para buscar una empresa
	 * 
	 * @return objeto response
	 */
	@GetMapping(value = "buscarEmpresaPorCedulaRep/{empCedulaRep}")
	public ResponseEntity<SbtEmpresa> buscarEmpresaPorCedulaRep(@PathVariable("empCedulaRep") String empCedulaRep){
		SbtEmpresa sbtEmpresa = sbtEmpresaService.buscarEmpresaPorCedulaRep(empCedulaRep) ;
		return new ResponseEntity<SbtEmpresa>(sbtEmpresa, HttpStatus.OK);
	}
	
	/**
	 * REST para guardar o actualizar una empresa
	 * 
	 * @param estudiante a guardar
	 */
	@PostMapping(path = "guardarEmpresa")
	public ResponseGenerico<String> guardarEmpresa(@RequestBody @Valid SbtEmpresaDTO sbtEmpresaDTO) {
		SbtEmpresa sbtEmpresa = new SbtEmpresa();
		sbtEmpresa.setEmpCodigo(sbtEmpresaDTO.getEmpCodigo());
		sbtEmpresa.setEmpCedulaRep(sbtEmpresaDTO.getEmpCedulaRep());
		sbtEmpresa.setEmpNombreRep(sbtEmpresaDTO.getEmpNombreRep());
		sbtEmpresa.setEmpDireccionRep(sbtEmpresaDTO.getEmpDireccionRep());
		sbtEmpresa.setEmpCedulaCon(sbtEmpresaDTO.getEmpCedulaCon());
		sbtEmpresa.setEmpNombreCon(sbtEmpresaDTO.getEmpNombreCon());
		sbtEmpresa.setEmpNombreEmp(sbtEmpresaDTO.getEmpNombreEmp());
		sbtEmpresa.setEmpDireccionCon(sbtEmpresaDTO.getEmpDireccionCon());
		sbtEmpresa.setEmpRuc(sbtEmpresaDTO.getEmpRuc());
		sbtEmpresa.setEmpCargoRep(sbtEmpresaDTO.getEmpCargoRep());
		sbtEmpresa.setEmpCargoCon(sbtEmpresaDTO.getEmpCargoCon());
		sbtEmpresa.setEmpTelefonoRep(sbtEmpresaDTO.getEmpTelefonoRep());
		sbtEmpresa.setEmpCelularCon(sbtEmpresaDTO.getEmpCelularCon());
		sbtEmpresa.setEmpCorreoRep(sbtEmpresaDTO.getEmpCorreoRep());
		sbtEmpresa.setEmpCorreoCon(sbtEmpresaDTO.getEmpCorreoCon());
		
		SbtSectorEmpresa sbtSectorEmpresa = sectorService.buscarSectorPorCodigo(sbtEmpresaDTO.getSemCodigo());
		sbtEmpresa.setSbtSectorEmpresa(sbtSectorEmpresa);

		//sbtEmpresa.setEmpIdentidad(Utils.generarNumeroIdentididad(sbtEmpresa.getEmpCodigo(), sede.getSedCodigo()));
		ResponseGenerico<String> response = new ResponseGenerico<>();
		try {
			sbtEmpresaService.guardar(sbtEmpresa);
			response.setId(sbtEmpresa.getEmpCodigo());
			response.setCodigoRespuesta(sbtEmpresa.getEmpNombreEmp());
			response.setMensaje("OK");
			//Enviar correo al email del contacto
			enviarCorreo(sbtEmpresaDTO.getEmpCorreoCon(), "Este es el asunto", "Este es el contenido");
			
			return response;
		} catch (Exception e) {
			response.setId(null);
			response.setCodigoRespuesta("Error, no se guardo la información");
			response.setMensaje(e.getMessage());
			return response;
		}
	}
	
	//Pasamos por parametro: destinatario, asunto y el mensaje
    public void enviarCorreo(String to, String subject, String content) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        mailSender.send(email);
    }	

}
