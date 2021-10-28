package ec.gob.educacion.service.impl.sellobt;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.repository.sellobt.EncEstPregRepository;
import ec.gob.educacion.sellobt.dto.EncuEstPregDTO;
import ec.gob.educacion.service.sellobt.EncEstPregService;

/**
 * Implementación de los servicios para derespuestas
 * 
 * @author Belen Changoluisa
 *
 */
@Service
public class EncEstPregServiceImpl implements EncEstPregService{
	
	@Autowired
	private EncEstPregRepository encEstPregRepository;

	@Override
	public List<EncuEstPregDTO> listarEstudianteEncuentaPregunta(long penTipoPregunta, long estCodigo) {
		// TODO Auto-generated method stub
		return encEstPregRepository.listarEstudianteEncuentaPregunta(penTipoPregunta, estCodigo);
	}


}
