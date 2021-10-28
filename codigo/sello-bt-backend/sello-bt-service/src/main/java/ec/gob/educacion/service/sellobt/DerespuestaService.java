package ec.gob.educacion.service.sellobt;


import java.util.List;

import ec.gob.educacion.sellobt.dto.DerespuestasDTO;

/**
 * Interfaz para Derespuesta
 * 
 * @author Belen Changoluisa
 *
 */
public interface DerespuestaService {
	
	/**
	 * Permite buscar un derespuesta
	 * 
	 * @return listar respuestas
	 * @author Belen Changoluisa
	 */
	List<DerespuestasDTO> listarDerespuesta(long preCodigo);
	


}
