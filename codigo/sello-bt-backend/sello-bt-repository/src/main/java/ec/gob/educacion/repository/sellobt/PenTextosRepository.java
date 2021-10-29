package ec.gob.educacion.repository.sellobt;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.model.asignaciones.PenTextos;

/**
* Repositorio para la entidad InsGrado
* 
* @author Jorge Quishpe
*
*/
@Repository
public interface PenTextosRepository extends JpaRepository<PenTextos, Integer>{
	
	/**
	 * Permite listar los textos por grado
	 * 
	 * @param estado a buscar
	 * @return lista de textos
	 * @author Belen Changoluisa
	 */

	List<PenTextos>  findByGraCodigoAndTxtEstado(@Param("graCodigo") Integer graCodigo,@Param("txtEstado") int txtEstado);
	


}
