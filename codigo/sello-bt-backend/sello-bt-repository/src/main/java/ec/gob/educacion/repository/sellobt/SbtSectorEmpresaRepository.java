package ec.gob.educacion.repository.sellobt;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.model.sellobt.SbtSectorEmpresa;

/**
* Repositorio para la entidad SbtSectorEmpresa
* * @author jbrito - 20211021
**/
@Repository
public interface SbtSectorEmpresaRepository extends JpaRepository<SbtSectorEmpresa, Long>{
	List<SbtSectorEmpresa> findAll();

	/**
	 * Permite buscar un sector
	 * 
	 * @param codigo a buscar
	 * @return objeto de sector
	 * @author jbrito - 20211021
	 */
	SbtSectorEmpresa findBySemCodigo(@Param("semCodigo") Long semCodigo);

}
