package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.infrastructure.entities.VenueEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VenueMapper {

    public Venue toDomain(VenueEntity entity) {
        if (entity == null)
            return null;
        return new Venue(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                entity.getCapacity(),
                entity.getEvents().stream().map(EventMapper::toDomainWithoutVenue).collect(Collectors.toList()));
    }

    public VenueEntity toEntity(Venue domain) {
        if (domain == null)
            return null;
        VenueEntity entity = new VenueEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setLocation(domain.getLocation());
        entity.setCapacity(domain.getCapacity());
        // Events are usually handled separately or require careful circular reference
        // handling
        return entity;
    }
}
