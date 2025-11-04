package eventos.catalogos.service;


import eventos.catalogos.entity.Event;
import eventos.catalogos.repository.EventRepository;
import eventos.catalogos.web.dto.EventRequest;
import eventos.catalogos.web.dto.EventResponse;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class EventServiceIm implements EventService {

    private final EventRepository repo;

    public EventServiceIm(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventResponse crear(EventRequest req) {

        if (repo.existsByNombreIgnoreCase(req.getNombre())) {
            throw new IllegalArgumentException("nombre duplicado");

        }

        var event = new Event(req.getNombre(), req.getFechaEvento(), req.getUbicacion(),req.getCiudad());
        var save = repo.save(event);

        return new EventResponse(
                save.getNombre(),
                save.getFechaEvento(),
                save.getUbicacion(),
                save.getCiudad()
        );
    }

    @Override
    public EventResponse obtenerPorId(Integer id) {
        var event = repo.findById(id).orElseThrow(()->new NoSuchElementException("evento no encontrado"));
        
        return  new EventResponse(event.getNombre(),event.getFechaEvento(),event.getUbicacion(),event.getCiudad());
        
    }

    @Override
    public List<EventResponse> listar() {
        return repo.findAll().stream()
                .map(event ->  new EventResponse(event.getNombre(), event.getFechaEvento(), event.getUbicacion(),event.getCiudad())).toList();
    }

    @Override
    public void Eliminar(Integer id) {
        var event = repo.findById(id);
        if (event == null) {
            throw new NoSuchElementException("evento no encontrado");
            
        }
        
        repo.deleteById(id);
    }
    
     @Override
    public EventResponse editar(Integer id, EventRequest req) {
        var event =repo.findById(id).orElseThrow(() -> new NoSuchElementException("no econtrado"));
        
        if (repo.existsByNombreIgnoreCase(req.getNombre())) {
            throw  new IllegalArgumentException("nombre duplicado");
            
        }
        
        event.setNombre(req.getNombre());
        event.setFechaEvento(req.getFechaEvento());
        event.setUbicacion(req.getUbicacion());
        
        var newEvent = repo.save(event);
        
        return new EventResponse(newEvent.getNombre(),newEvent.getFechaEvento(),newEvent.getUbicacion(),newEvent.getCiudad());
        
    }
    
}
