package controller;

import Service.SensorService;
import model.Sensor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {

	private final SensorService sensorService;

	public SensorController(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	@PostMapping
	public ResponseEntity<Sensor> cadastrar(@RequestBody Sensor sensor) {
		Sensor novoSensor = sensorService.cadastrar(sensor);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoSensor);
	}

	@GetMapping
	public List<Sensor> listarTodos() {
		return sensorService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sensor> buscarPorId(@PathVariable Long id) {
		return sensorService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Sensor> atualizar(@PathVariable Long id, @RequestBody Sensor sensor) {
		return sensorService.atualizar(id, sensor)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		boolean removido = sensorService.remover(id);
		if (!removido) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/local/{local}")
	public List<Sensor> buscarPorLocal(@PathVariable String local) {
		return sensorService.buscarPorLocal(local);
	}
}
