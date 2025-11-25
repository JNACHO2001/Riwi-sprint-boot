package eventos.catalogos.application.services;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.domain.ports.in.VenueUseCase;
import eventos.catalogos.domain.ports.out.VenueRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService implements VenueUseCase {

    private final VenueRepositoryPort venueRepositoryPort;

    public VenueService(VenueRepositoryPort venueRepositoryPort) {
        this.venueRepositoryPort = venueRepositoryPort;
    }

    @Override
    public Venue createVenue(Venue venue) {
        return venueRepositoryPort.save(venue);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueRepositoryPort.findAll();
    }

    @Override
    public Optional<Venue> getVenueById(String id) {
        return venueRepositoryPort.findById(id);
    }

    @Override
    public void deleteVenue(String id) {
        venueRepositoryPort.deleteById(id);
    }
}
