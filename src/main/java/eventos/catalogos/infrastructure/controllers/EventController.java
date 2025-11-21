package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.domain.ports.in.EventUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventUseCase eventUseCase;

    public EventController(EventUseCase eventUseCase) {
        this.eventUseCase = eventUseCase;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventUseCase.createEvent(event), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventUseCase.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventUseCase.getAllEvents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventUseCase.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/venue/{venueId}")
    public ResponseEntity<List<Event>> getEventsByVenue(@PathVariable Long venueId) {
        return ResponseEntity.ok(eventUseCase.getEventsByVenue(venueId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) Long venueId) {
        return ResponseEntity.ok(eventUseCase.searchEvents(status, start, end, venueId));
    }
}
