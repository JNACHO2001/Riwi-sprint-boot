package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.domain.ports.out.EventRepositoryPort;
import eventos.catalogos.infrastructure.entities.EventEntity;
import eventos.catalogos.infrastructure.entities.mapper.EventMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EventRepositoryAdapter implements EventRepositoryPort {

    private final JpaEventRepository jpaEventRepository;
    private final EventMapper eventMapper;

    public EventRepositoryAdapter(JpaEventRepository jpaEventRepository, EventMapper eventMapper) {
        this.jpaEventRepository = jpaEventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public Event save(Event event) {
        EventEntity entity = eventMapper.toEntity(event);
        return eventMapper.toDomain(jpaEventRepository.save(entity));
    }

    @Override
    public Optional<Event> findById(Long id) {
        return jpaEventRepository.findById(id).map(eventMapper::toDomain);
    }

    @Override
    public List<Event> findAll() {
        return jpaEventRepository.findAll().stream()
                .map(eventMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaEventRepository.deleteById(id);
    }

    @Override
    public List<Event> findByVenueId(Long venueId) {
        return jpaEventRepository.findByVenueId(venueId).stream()
                .map(eventMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> search(String status, LocalDateTime start, LocalDateTime end, Long venueId) {
        Specification<EventEntity> spec = Specification.where(EventSpecifications.hasStatus(status))
                .and(EventSpecifications.dateBetween(start, end))
                .and(EventSpecifications.hasVenueId(venueId));

        return jpaEventRepository.findAll(spec).stream()
                .map(eventMapper::toDomain)
                .collect(Collectors.toList());
    }
}
