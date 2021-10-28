package ec.gob.educacion.service.impl.sellobt;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.repository.sellobt.DerespuestasRepository;
import ec.gob.educacion.sellobt.dto.DerespuestasDTO;
import ec.gob.educacion.service.sellobt.DerespuestaService;


/**
 * Implementación de los servicios para derespuestas
 * 
 * @author Belen Changoluisa
 *
 */
@Service
public class DerespuestaServiceImpl implements DerespuestaService{
	
	@Autowired
	private DerespuestasRepository derespuestasRepository;

	@Override
	public List<DerespuestasDTO> listarDerespuesta(long preCodigo) {
		// TODO Auto-generated method stub
		return derespuestasRepository.listaRespuesta(preCodigo,BigDecimal.valueOf(1));
	}


}
