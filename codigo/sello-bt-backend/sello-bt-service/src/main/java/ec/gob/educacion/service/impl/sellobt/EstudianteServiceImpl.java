package ec.gob.educacion.service.impl.sellobt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.enumeraciones.EstadoEnum;
import ec.gob.educacion.model.sellobt.PenEstudiante;
import ec.gob.educacion.repository.sellobt.EstudianteRepository;
import ec.gob.educacion.service.sellobt.EstudianteService;


/**
 * Implementación de los servicios para PenEstudiante
 * 
 * @author Jorge Quishpe
 *
 */
@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public PenEstudiante buscarEstudiantePorCedula(String estCedula) {
		return estudianteRepository.findByEstCedulaAndEstEstado(estCedula,EstadoEnum.ACTIVO.getEstado());
	}
	
	@Override
	public PenEstudiante buscarEstudiantePorIdentidad(String estIdentidad) {
		return estudianteRepository.findByEstIdentidadAndEstEstado(estIdentidad,EstadoEnum.ACTIVO.getEstado());
	}
	
	@Override
	public PenEstudiante guardar(PenEstudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	public PenEstudiante buscarEstudiantePorCodigo(long estCodigo) {
		return estudianteRepository.findByEstCodigo(estCodigo);
	}

}
