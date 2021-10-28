package ec.gob.educacion.repository.sellobt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.model.sellobt.SbtEmpresa;

/**
* Repositorio para la entidad SbtEmpresa
* 
* @author jbrito - 20211022
*
*/
@Repository
public interface SbtEmpresaRepository extends JpaRepository<SbtEmpresa, Long>{
	
	/**
	 * Permite buscar una empresa
	 * 
	 * @param estado a buscar
	 * @param cedula a buscar
	 * @return objeto de empresa
	 * @author jbrito - 20211022
	 */
	SbtEmpresa findByEmpCedulaRep(@Param("empCedulaRep") String empCedulaRep);
	
	/**
	 * Permite buscar una empresa
	 * 
	 * @param codigo a buscar
	 * @author jbrito - 20211022
	 */
	SbtEmpresa findByEmpCodigo(@Param("empCodigo") long empCodigo);

}
