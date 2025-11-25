package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.VenueDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoVenueRepository extends MongoRepository<VenueDocument, String> {
}
