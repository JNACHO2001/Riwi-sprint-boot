package eventos.catalogos.domain.ports.out;

import eventos.catalogos.domain.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventRepositoryPort {
    Event save(Event event);

    Optional<Event> findById(Long id);

    List<Event> findAll();

    void deleteById(Long id);

    List<Event> findByVenueId(Long venueId);

    List<Event> search(String status, java.time.LocalDateTime start, java.time.LocalDateTime end, Long venueId);
}
