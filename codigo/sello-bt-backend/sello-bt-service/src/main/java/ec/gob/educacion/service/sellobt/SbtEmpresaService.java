package ec.gob.educacion.service.sellobt;

import ec.gob.educacion.model.sellobt.SbtEmpresa;

/**
 * Interfaz para SbtEmpresa
 * 
 * @author jbrito - 20211022
 *
 */
public interface SbtEmpresaService {
	
	/**
	 * Permite buscar una empresa
	 * 
	 * @param estado a buscar
	 * @param cedula a buscar
	 * @return objeto de empresa
	 * 
	 * @author jbrito - 20211022
	 */
	SbtEmpresa buscarEmpresaPorCedulaRep(String empCedulaRep);
	
	/**
	 * Permite persistir una empresa
	 * 
	 * @param empresa a guardar o actualizar
	 * @return empresa guardado
	 */
	SbtEmpresa guardar(SbtEmpresa sbtEmpresa);
	
	/**
	 * Permite buscar una empresa
	 * 
	 * @param codigo a buscar
	 * @author jbrito - 20211022
	 */
	SbtEmpresa buscarEmpresaPorCodigo(long empCodigo);

}
