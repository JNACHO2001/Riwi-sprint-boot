package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.infrastructure.entities.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event toDomain(EventEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Event(
                entity.getId(),
                entity.getName(),
                entity.getDate(),
                entity.getStatus(),
                entity.getVenueId());
    }

    public EventEntity toEntity(Event domain) {
        if (domain == null) {
            return null;
        }
        return new EventEntity(
                domain.getId(),
                domain.getName(),
                domain.getDate(),
                domain.getStatus(),
                domain.getVenueId());
    }
}
