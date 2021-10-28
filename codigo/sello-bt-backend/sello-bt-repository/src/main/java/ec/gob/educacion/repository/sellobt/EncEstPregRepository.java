package ec.gob.educacion.repository.sellobt;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.educacion.model.sellobt.PenEstudiante;
import ec.gob.educacion.sellobt.dto.EncuEstPregDTO;

/**
* Repositorio para la entidad listarPregunta
* 
* @author Belen Changoluisa
*
*/
@Repository
public interface EncEstPregRepository extends JpaRepository<PenEstudiante, Integer>{
	
	/**
	 * Permite listar codPregunta, estudiante
	 * 
	 * @return lista de preguntas
	 * @author Belen Changoluisa
	 */	
	@Query(value = "Select new ec.gob.educacion.sellobt.dto.EncuEstPregDTO (e.encCodigo,a.tpeCodigo, p.estCedula "
			+ " ) from PenEstudiante p "
			+ " inner join PenEncuesta e on e.penEstudiante = p.estCodigo "
			+ " inner join PenPregunta t on t.preCodigo = e.preCodigo "
			+ "inner join PenTipoPregunta a on a.tpeCodigo = t.penTipoPregunta "
			+ " where a.tpeCodigo=:penTipoPregunta and p.estCodigo =:estCodigo")
	List<EncuEstPregDTO>  listarEstudianteEncuentaPregunta(@Param("penTipoPregunta") long penTipoPregunta, @Param("estCodigo") long estCodigo);

}
