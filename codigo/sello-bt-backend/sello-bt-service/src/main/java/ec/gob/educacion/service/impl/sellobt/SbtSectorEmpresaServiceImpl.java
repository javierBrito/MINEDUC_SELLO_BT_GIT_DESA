package ec.gob.educacion.service.impl.sellobt;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.sellobt.SbtSectorEmpresa;
import ec.gob.educacion.repository.sellobt.SbtSectorEmpresaRepository;
import ec.gob.educacion.service.sellobt.SbtSectorEmpresaService;

/**
 * Implementación de los servicios para SbtSectorEmpresa
 * @author jbrito - 20211022
 */
@Service
public class SbtSectorEmpresaServiceImpl implements SbtSectorEmpresaService {
	@Autowired
	private SbtSectorEmpresaRepository sbtSectorEmpresaRepository;

	@Override
	public List<SbtSectorEmpresa> listarSector() {
		return sbtSectorEmpresaRepository.findAll();
	}
	
	@Override
	public SbtSectorEmpresa buscarSectorPorCodigo(Long semCodigo) {
		return sbtSectorEmpresaRepository.findBySemCodigo(semCodigo);
	}
}
