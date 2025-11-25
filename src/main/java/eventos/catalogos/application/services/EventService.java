package eventos.catalogos.application.services;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.domain.ports.in.EventUseCase;
import eventos.catalogos.domain.ports.out.EventRepositoryPort;
import eventos.catalogos.domain.ports.out.VenueRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventUseCase {

    private final EventRepositoryPort eventRepositoryPort;
    private final VenueRepositoryPort venueRepositoryPort;

    public EventService(EventRepositoryPort eventRepositoryPort, VenueRepositoryPort venueRepositoryPort) {
        this.eventRepositoryPort = eventRepositoryPort;
        this.venueRepositoryPort = venueRepositoryPort;
    }

    @Override
    @Transactional
    public Event createEvent(Event event) {
        if (event.getVenueId() != null && venueRepositoryPort.findById(event.getVenueId()).isEmpty()) {
            throw new IllegalArgumentException("Venue not found with ID: " + event.getVenueId());
        }
        return eventRepositoryPort.save(event);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAllEvents() {
        return eventRepositoryPort.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Event> getEventById(Long id) {
        return eventRepositoryPort.findById(id);
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        eventRepositoryPort.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEventsByVenue(String venueId) {
        return eventRepositoryPort.findByVenueId(venueId);
    }
}
