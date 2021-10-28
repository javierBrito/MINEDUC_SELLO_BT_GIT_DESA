package ec.gob.educacion.service.impl.sellobt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.sellobt.SbtEmpresa;
import ec.gob.educacion.repository.sellobt.SbtEmpresaRepository;
import ec.gob.educacion.service.sellobt.SbtEmpresaService;

/**
 * Implementación de los servicios para SbtEmpresa
 * 
 * @author jbrito - 20211022
 *
 */
@Service
public class SbtEmpresaServiceImpl implements SbtEmpresaService{
	
	@Autowired
	private SbtEmpresaRepository sbtEmpresaRepository;

	@Override
	public SbtEmpresa buscarEmpresaPorCedulaRep(String empCedulaRep) {
		return sbtEmpresaRepository.findByEmpCedulaRep(empCedulaRep);
	}
	
	@Override
	public SbtEmpresa guardar(SbtEmpresa sbtEmpresa) {
		return sbtEmpresaRepository.save(sbtEmpresa);
	}

	@Override
	public SbtEmpresa buscarEmpresaPorCodigo(long empCodigo) {
		return sbtEmpresaRepository.findByEmpCodigo(empCodigo);
	}

}
