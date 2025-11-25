package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByVenueId(String venueId);
}
