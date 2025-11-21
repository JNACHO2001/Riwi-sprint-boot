package eventos.catalogos.domain.ports.in;

import eventos.catalogos.domain.model.Venue;
import java.util.List;
import java.util.Optional;

public interface VenueUseCase {
    Venue createVenue(Venue venue);

    Optional<Venue> getVenueById(Long id);

    List<Venue> getAllVenues();

    void deleteVenue(Long id);
}
