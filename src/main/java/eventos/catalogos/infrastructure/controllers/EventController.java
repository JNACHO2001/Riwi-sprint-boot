package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.domain.ports.in.EventUseCase;
import eventos.catalogos.infrastructure.dto.EventRequest;
import eventos.catalogos.infrastructure.dto.EventResponse;
import eventos.catalogos.infrastructure.dto.mapper.EventDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventUseCase eventUseCase;
    private final EventDTOMapper eventDTOMapper;

    public EventController(EventUseCase eventUseCase, EventDTOMapper eventDTOMapper) {
        this.eventUseCase = eventUseCase;
        this.eventDTOMapper = eventDTOMapper;
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest request) {
        var event = eventDTOMapper.toDomain(request);
        var createdEvent = eventUseCase.createEvent(event);
        return new ResponseEntity<>(eventDTOMapper.toResponse(createdEvent), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        var events = eventUseCase.getAllEvents();
        var responses = events.stream()
                .map(eventDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        return eventUseCase.getEventById(id)
                .map(eventDTOMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventUseCase.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/venue/{venueId}")
    public ResponseEntity<List<EventResponse>> getEventsByVenue(@PathVariable String venueId) {
        var events = eventUseCase.getEventsByVenue(venueId);
        var responses = events.stream()
                .map(eventDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
