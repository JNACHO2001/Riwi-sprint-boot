package eventos.catalogos.domain.ports.out;

import eventos.catalogos.domain.model.Venue;
import java.util.List;
import java.util.Optional;

public interface VenueRepositoryPort {
    Venue save(Venue venue);

    Optional<Venue> findById(Long id);

    List<Venue> findAll();

    void deleteById(Long id);
}
