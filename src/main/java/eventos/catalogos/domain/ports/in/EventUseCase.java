package eventos.catalogos.domain.ports.in;

import eventos.catalogos.domain.model.Event;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventUseCase {
    Event createEvent(Event event);

    Optional<Event> getEventById(Long id);

    List<Event> getAllEvents();

    void deleteEvent(Long id);

    List<Event> getEventsByVenue(Long venueId);

    List<Event> searchEvents(String status, LocalDateTime start, LocalDateTime end, Long venueId);
}
