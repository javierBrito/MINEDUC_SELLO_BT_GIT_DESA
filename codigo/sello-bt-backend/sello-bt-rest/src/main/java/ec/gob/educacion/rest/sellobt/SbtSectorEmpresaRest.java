package ec.gob.educacion.rest.sellobt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.educacion.model.sellobt.SbtSectorEmpresa;
import ec.gob.educacion.service.sellobt.SbtSectorEmpresaService;

@RestController
@RequestMapping("private/")
public class SbtSectorEmpresaRest {
	
	@Autowired
	private SbtSectorEmpresaService sbtSectorEmpresaService;	
	
	@GetMapping(value = "sector")
	public ResponseEntity<List<SbtSectorEmpresa>> listarSector(){
		List<SbtSectorEmpresa> listarSector = sbtSectorEmpresaService.listarSector();
		
		return new ResponseEntity<List<SbtSectorEmpresa>>(listarSector, HttpStatus.OK);
		
	}

}
