package Service;

import Repository.SensorRepository;
import model.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

	private final SensorRepository sensorRepository;

	public SensorService(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	public Sensor cadastrar(Sensor sensor) {
		return sensorRepository.save(sensor);
	}

	public List<Sensor> listarTodos() {
		return sensorRepository.findAll();
	}

	public Optional<Sensor> buscarPorId(Long id) {
		return sensorRepository.findById(id);
	}

	public List<Sensor> buscarPorLocal(String local) {
		return sensorRepository.findByLocalIgnoreCase(local);
	}

	public Optional<Sensor> atualizar(Long id, Sensor dadosAtualizados) {
		return sensorRepository.findById(id)
				.map(sensorExistente -> {
					sensorExistente.setUnidade(dadosAtualizados.getUnidade());
					sensorExistente.setValor(dadosAtualizados.getValor());
					sensorExistente.setLocal(dadosAtualizados.getLocal());
					return sensorRepository.save(sensorExistente);
				});
	}

	public boolean remover(Long id) {
		if (!sensorRepository.existsById(id)) {
			return false;
		}
		sensorRepository.deleteById(id);
		return true;
	}
}
