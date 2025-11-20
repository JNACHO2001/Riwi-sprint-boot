
package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SpringUserMongoRepository extends MongoRepository<UserDocument, Long>{
    
}
