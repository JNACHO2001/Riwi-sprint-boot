package eventos.catalogos.controlador;

import eventos.catalogos.service.InscripcionServiceIm;
import eventos.catalogos.web.dto.InscripcionResponse;
import eventos.catalogos.web.dto.InscrpcionRequest;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/inscripcion")
public class InscripcionControlador {

    private final InscripcionServiceIm service;

    public InscripcionControlador(InscripcionServiceIm service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InscripcionResponse> crear(@Valid @RequestBody InscrpcionRequest req) {
        InscripcionResponse response = service.crear(req);

        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<InscripcionResponse>> listar() {
        return ResponseEntity.ok(service.listar());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);

        return ResponseEntity.ok("ELIMINADO");

    }

}
