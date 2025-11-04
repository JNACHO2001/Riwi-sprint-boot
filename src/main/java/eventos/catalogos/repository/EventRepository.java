package eventos.catalogos.repository;


import eventos.catalogos.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository  extends JpaRepository<Event, Integer>{
    
    boolean existsByNombreIgnoreCase(String nombre);

}
