
package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long>{
    
}
