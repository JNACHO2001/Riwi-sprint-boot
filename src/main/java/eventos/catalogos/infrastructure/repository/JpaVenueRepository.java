package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaVenueRepository extends JpaRepository<VenueEntity, Long> {
}
