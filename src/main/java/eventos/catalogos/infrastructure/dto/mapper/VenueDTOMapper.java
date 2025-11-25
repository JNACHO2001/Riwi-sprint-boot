package eventos.catalogos.infrastructure.dto.mapper;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.infrastructure.dto.VenueRequest;
import eventos.catalogos.infrastructure.dto.VenueResponse;
import org.springframework.stereotype.Component;

@Component
public class VenueDTOMapper {

    public Venue toDomain(VenueRequest request) {
        if (request == null) {
            return null;
        }
        return new Venue(
                null, // ID will be generated
                request.getName(),
                request.getLocation(),
                request.getCapacity());
    }

    public VenueResponse toResponse(Venue domain) {
        if (domain == null) {
            return null;
        }
        return new VenueResponse(
                domain.getId(),
                domain.getName(),
                domain.getLocation(),
                domain.getCapacity());
    }
}
