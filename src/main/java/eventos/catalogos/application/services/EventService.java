package eventos.catalogos.application.services;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.domain.ports.in.EventUseCase;
import eventos.catalogos.domain.ports.out.EventRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventUseCase {

    private final EventRepositoryPort eventRepositoryPort;

    public EventService(EventRepositoryPort eventRepositoryPort) {
        this.eventRepositoryPort = eventRepositoryPort;
    }

    @Override
    @Transactional
    public Event createEvent(Event event) {
        return eventRepositoryPort.save(event);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Event> getEventById(Long id) {
        return eventRepositoryPort.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAllEvents() {
        return eventRepositoryPort.findAll();
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        eventRepositoryPort.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByVenue(Long venueId) {
        return eventRepositoryPort.findByVenueId(venueId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> searchEvents(String status, LocalDateTime start, LocalDateTime end, Long venueId) {
        return eventRepositoryPort.search(status, start, end, venueId);
    }
}
