package eventos.catalogos.application.services;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.domain.ports.in.VenueUseCase;
import eventos.catalogos.domain.ports.out.VenueRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService implements VenueUseCase {

    private final VenueRepositoryPort venueRepositoryPort;

    public VenueService(VenueRepositoryPort venueRepositoryPort) {
        this.venueRepositoryPort = venueRepositoryPort;
    }

    @Override
    @Transactional
    public Venue createVenue(Venue venue) {
        return venueRepositoryPort.save(venue);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Venue> getVenueById(Long id) {
        return venueRepositoryPort.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venue> getAllVenues() {
        return venueRepositoryPort.findAll();
    }

    @Override
    @Transactional
    public void deleteVenue(Long id) {
        venueRepositoryPort.deleteById(id);
    }
}
