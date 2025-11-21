package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.domain.ports.out.VenueRepositoryPort;
import eventos.catalogos.infrastructure.entities.VenueEntity;
import eventos.catalogos.infrastructure.entities.mapper.VenueMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VenueRepositoryAdapter implements VenueRepositoryPort {

    private final JpaVenueRepository jpaVenueRepository;
    private final VenueMapper venueMapper;

    public VenueRepositoryAdapter(JpaVenueRepository jpaVenueRepository, VenueMapper venueMapper) {
        this.jpaVenueRepository = jpaVenueRepository;
        this.venueMapper = venueMapper;
    }

    @Override
    public Venue save(Venue venue) {
        VenueEntity entity = venueMapper.toEntity(venue);
        return venueMapper.toDomain(jpaVenueRepository.save(entity));
    }

    @Override
    public Optional<Venue> findById(Long id) {
        return jpaVenueRepository.findById(id).map(venueMapper::toDomain);
    }

    @Override
    public List<Venue> findAll() {
        return jpaVenueRepository.findAll().stream()
                .map(venueMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaVenueRepository.deleteById(id);
    }
}
