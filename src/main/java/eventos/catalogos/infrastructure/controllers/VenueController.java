package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.domain.ports.in.VenueUseCase;
import eventos.catalogos.infrastructure.dto.VenueRequest;
import eventos.catalogos.infrastructure.dto.VenueResponse;
import eventos.catalogos.infrastructure.dto.mapper.VenueDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final VenueUseCase venueUseCase;
    private final VenueDTOMapper venueDTOMapper;

    public VenueController(VenueUseCase venueUseCase, VenueDTOMapper venueDTOMapper) {
        this.venueUseCase = venueUseCase;
        this.venueDTOMapper = venueDTOMapper;
    }

    @PostMapping
    public ResponseEntity<VenueResponse> createVenue(@RequestBody VenueRequest request) {
        var venue = venueDTOMapper.toDomain(request);
        var createdVenue = venueUseCase.createVenue(venue);
        return new ResponseEntity<>(venueDTOMapper.toResponse(createdVenue), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VenueResponse>> getAllVenues() {
        var venues = venueUseCase.getAllVenues();
        var responses = venues.stream()
                .map(venueDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueResponse> getVenueById(@PathVariable String id) {
        return venueUseCase.getVenueById(id)
                .map(venueDTOMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable String id) {
        venueUseCase.deleteVenue(id);
        return ResponseEntity.noContent().build();
    }
}
