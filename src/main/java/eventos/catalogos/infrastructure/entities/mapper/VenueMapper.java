package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Venue;
import eventos.catalogos.infrastructure.entities.VenueDocument;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {

    public Venue toDomain(VenueDocument entity) {
        if (entity == null) {
            return null;
        }
        return new Venue(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                entity.getCapacity());
    }

    public VenueDocument toDocument(Venue domain) {
        if (domain == null) {
            return null;
        }
        return new VenueDocument(
                domain.getId(),
                domain.getName(),
                domain.getLocation(),
                domain.getCapacity());
    }
}
