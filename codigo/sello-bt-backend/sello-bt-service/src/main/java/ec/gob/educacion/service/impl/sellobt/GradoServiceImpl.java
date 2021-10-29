package ec.gob.educacion.service.impl.sellobt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.asignaciones.InsGrado;
import ec.gob.educacion.model.enumeraciones.EstadoEnum;
import ec.gob.educacion.repository.sellobt.GradoRepository;
import ec.gob.educacion.service.sellobt.GradoService;


/**
 * Implementación de los servicios para Grado
 * 
 * @author Jorge Quishpe
 *
 */
@Service
public class GradoServiceImpl implements GradoService{
	
	@Autowired
	private GradoRepository gradoRepository;

	@Override
	public List<InsGrado>  listarGradosNiveles() {
		return gradoRepository.listarGradosNiveles(EstadoEnum.ACTIVO.getEstado());
	}

}
