package eventos.catalogos.controlador;

import eventos.catalogos.service.EventServiceIm;
import eventos.catalogos.web.dto.EventRequest;
import eventos.catalogos.web.dto.EventResponse;
import jakarta.validation.Valid;
import java.util.List;
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

@RestController
@RequestMapping("api/event")
public class EventControlador {

    private final EventServiceIm service;

    public EventControlador(EventServiceIm service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventResponse> crear(@Valid @RequestBody EventRequest req) {
        var res = service.crear(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> listar() {

        return ResponseEntity.ok(service.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> obtener(@PathVariable Integer id) {

        return ResponseEntity.ok(service.obtenerPorId(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.Eliminar(id);
        return ResponseEntity.ok("eliminado");

    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> editar(@PathVariable Integer id, @RequestBody EventRequest e) {
        var res = service.editar(id, e);
        return ResponseEntity.ok().body(res);

    }

}
