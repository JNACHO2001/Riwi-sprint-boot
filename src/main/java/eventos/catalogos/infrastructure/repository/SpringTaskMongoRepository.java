
package eventos.catalogos.infrastructure.repository;


import eventos.catalogos.infrastructure.entities.TaskDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringTaskMongoRepository extends MongoRepository<TaskDocument, Long>{
    
    
}
