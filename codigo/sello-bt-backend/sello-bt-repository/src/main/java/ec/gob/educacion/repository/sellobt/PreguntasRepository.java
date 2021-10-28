package ec.gob.educacion.repository.sellobt;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.sellobt.PenPregunta;
import ec.gob.educacion.sellobt.dto.PreguntasDTO;

/**
* Repositorio para la entidad listarPregunta
* 
* @author Belen Changoluisa
*
*/
@Repository
public interface PreguntasRepository extends JpaRepository<PenPregunta, Integer>{
	
	/**
	 * Permite listar preguntas
	 * 
	 * @return lista de preguntas
	 * @author Belen Changoluisa
	 */

	@Query(value = "Select new ec.gob.educacion.sellobt.dto.PreguntasDTO (p.preCodigo,p.prePresentar, p.prePregunta, "
			+ " t.tpeCodigo) from PenPregunta p "
			+ " inner join PenNivelPregunta n on p.preCodigo = n.penPregunta "
			+ " inner join PenTipoPregunta t on t.tpeCodigo = p.penTipoPregunta "
			+ " where p.preEstado=:preEstado and t.tpeCodigo =:tpeCodigo "
			+ " and n.codGrado =:codGrado ")
	List<PreguntasDTO>  listarPreguntaPortpeCodigo(@Param("preEstado") BigDecimal preEstado, @Param("tpeCodigo") long tpeCodigo ,@Param("codGrado") BigDecimal  codGrado);

}
