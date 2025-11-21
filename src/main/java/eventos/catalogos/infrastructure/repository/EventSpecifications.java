package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDateTime;

public class EventSpecifications {

    public static Specification<EventEntity> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null || status.isEmpty())
                return null;
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<EventEntity> hasVenueId(Long venueId) {
        return (root, query, criteriaBuilder) -> {
            if (venueId == null)
                return null;
            return criteriaBuilder.equal(root.get("venue").get("id"), venueId);
        };
    }

    public static Specification<EventEntity> dateBetween(LocalDateTime start, LocalDateTime end) {
        return (root, query, criteriaBuilder) -> {
            if (start == null || end == null)
                return null;
            return criteriaBuilder.between(root.get("date"), start, end);
        };
    }
}
