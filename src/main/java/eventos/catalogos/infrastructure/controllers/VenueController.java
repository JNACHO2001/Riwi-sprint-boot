package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.domain.ports.in.VenueUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final VenueUseCase venueUseCase;

    public VenueController(VenueUseCase venueUseCase) {
        this.venueUseCase = venueUseCase;
    }

    @PostMapping
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        return new ResponseEntity<>(venueUseCase.createVenue(venue), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        return venueUseCase.getVenueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        return ResponseEntity.ok(venueUseCase.getAllVenues());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueUseCase.deleteVenue(id);
        return ResponseEntity.noContent().build();
    }
}
