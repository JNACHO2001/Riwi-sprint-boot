package eventos.catalogos.service;
import eventos.catalogos.web.dto.EventRequest;
import eventos.catalogos.web.dto.EventResponse;
import java.util.List;

public interface EventService {
    EventResponse crear(EventRequest req );
    EventResponse obtenerPorId(Integer id);
    List<EventResponse>listar();
    public void Eliminar(Integer id );
       EventResponse editar(Integer id, EventRequest req);
    

}
