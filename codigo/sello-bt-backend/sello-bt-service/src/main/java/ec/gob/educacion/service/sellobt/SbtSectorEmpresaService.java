package ec.gob.educacion.service.sellobt;

import java.util.List;
import ec.gob.educacion.model.sellobt.SbtSectorEmpresa;

/**
 * Interfaz para SbtSectorEmpresa
 * @author jbrito -20211021
 *
 */
public interface SbtSectorEmpresaService {
	
	List<SbtSectorEmpresa> listarSector();
	
	/**
	 * Permite buscar un sector
	 * 
	 * @param codigo a buscar
	 * @return objeto de sector
	 * @author jbrito - 20211021
	 */
	SbtSectorEmpresa buscarSectorPorCodigo(Long semCodigo);

}
