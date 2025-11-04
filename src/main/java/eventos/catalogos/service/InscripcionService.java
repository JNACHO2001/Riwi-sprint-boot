package eventos.catalogos.service;


import eventos.catalogos.web.dto.InscripcionResponse;
import eventos.catalogos.web.dto.InscrpcionRequest;
import java.util.List;

public interface InscripcionService {
    
    InscripcionResponse crear(InscrpcionRequest req);
    List<InscripcionResponse>listar();
    public void eliminar(Integer id);
    
    

}
