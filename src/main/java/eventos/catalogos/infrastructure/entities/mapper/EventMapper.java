package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.infrastructure.entities.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public static Event toDomainWithoutVenue(EventEntity entity) {
        if (entity == null)
            return null;
        return new Event(
                entity.getId(),
                entity.getName(),
                entity.getDate(),
                null // Avoid circular recursion
        );
    }

    public Event toDomain(EventEntity entity) {
        if (entity == null)
            return null;
        VenueMapper venueMapper = new VenueMapper();
        return new Event(
                entity.getId(),
                entity.getName(),
                entity.getDate(),
                venueMapper.toDomain(entity.getVenue()));
    }

    public EventEntity toEntity(Event domain) {
        if (domain == null)
            return null;
        EventEntity entity = new EventEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setDate(domain.getDate());
        // Venue needs to be set via service or repository lookup usually
        return entity;
    }
}
