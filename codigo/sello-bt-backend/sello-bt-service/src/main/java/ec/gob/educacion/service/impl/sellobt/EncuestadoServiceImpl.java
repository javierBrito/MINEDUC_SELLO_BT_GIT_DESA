package ec.gob.educacion.service.impl.sellobt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.repository.sellobt.EncuestadoRepository;
import ec.gob.educacion.sellobt.dto.EncuestadoDTO;
import ec.gob.educacion.service.sellobt.EncuestadoService;

/**
 * Implementación de los servicios para PenEstudiante
 * 
 * @author Belen Changoluisa
 *
 */
@Service
public class EncuestadoServiceImpl implements EncuestadoService{
	
	@Autowired
	private EncuestadoRepository encuestadoRepository;

	@Override
	public EncuestadoDTO buscarEncuestadoPorCedula(String estCedula) {
		// TODO Auto-generated method stub
		return encuestadoRepository.findByEncuestadoDTO(estCedula);
	}
	
	@Override
	public EncuestadoDTO buscarEcuestadoPorCodigo(long estCodigo) {
		return encuestadoRepository.findByEncuestadoCodigo(estCodigo);
	}
	
	

}
