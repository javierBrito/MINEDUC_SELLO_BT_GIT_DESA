package ec.gob.educacion.service.sellobt;

import java.util.List;

import ec.gob.educacion.model.sellobt.PenSedePen;


/**
 * Interfaz para PenSede
 * 
 * @author Jorge Quishpe
 *
 */
public interface PenSedePenService {
	
	List<PenSedePen> listarSede(Integer sedEstado);
	
	/**
	 * Permite buscar un sede
	 * 
	 * @param codigo a buscar
	 * @return objeto de sede
	 * @author Jorge Quishpe
	 */
	PenSedePen buscarSedePorCodigo(Long sedCodigo);

}
