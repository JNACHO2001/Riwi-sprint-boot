package eventos.catalogos.infrastructure.dto.mapper;

import eventos.catalogos.domain.model.Event;
import eventos.catalogos.infrastructure.dto.EventRequest;
import eventos.catalogos.infrastructure.dto.EventResponse;
import org.springframework.stereotype.Component;

@Component
public class EventDTOMapper {

    public Event toDomain(EventRequest request) {
        if (request == null) {
            return null;
        }
        return new Event(
                null, // ID will be generated
                request.getName(),
                request.getDate(),
                request.getStatus(),
                request.getVenueId());
    }

    public EventResponse toResponse(Event domain) {
        if (domain == null) {
            return null;
        }
        return new EventResponse(
                domain.getId(),
                domain.getName(),
                domain.getDate(),
                domain.getStatus(),
                domain.getVenueId());
    }
}
