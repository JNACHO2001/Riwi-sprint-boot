package eventos.catalogos.domain.ports.out;

import eventos.catalogos.domain.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventRepositoryPort {
    Event save(Event event);

    Optional<Event> findById(Long id);

    List<Event> findAll();

    void deleteById(Long id);

    List<Event> findByVenueId(String venueId);
}
