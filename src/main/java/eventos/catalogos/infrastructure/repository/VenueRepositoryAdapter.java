package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.domain.ports.out.VenueRepositoryPort;
import eventos.catalogos.infrastructure.entities.mapper.VenueMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VenueRepositoryAdapter implements VenueRepositoryPort {

    private final MongoVenueRepository mongoVenueRepository;
    private final VenueMapper venueMapper;

    public VenueRepositoryAdapter(MongoVenueRepository mongoVenueRepository, VenueMapper venueMapper) {
        this.mongoVenueRepository = mongoVenueRepository;
        this.venueMapper = venueMapper;
    }

    @Override
    public Venue save(Venue venue) {
        return venueMapper.toDomain(mongoVenueRepository.save(venueMapper.toDocument(venue)));
    }

    @Override
    public Optional<Venue> findById(String id) {
        return mongoVenueRepository.findById(id).map(venueMapper::toDomain);
    }

    @Override
    public List<Venue> findAll() {
        return mongoVenueRepository.findAll().stream()
                .map(venueMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        mongoVenueRepository.deleteById(id);
    }
}
