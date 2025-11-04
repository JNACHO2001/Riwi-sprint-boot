package eventos.catalogos.web.dto;
import java.time.LocalDate;


public class InscripcionResponse {
    
    private LocalDate fechaInscripcion;
    private String nombreUser;
    private String nombreEvento;

    public InscripcionResponse(LocalDate fechaInscripcion, String nombreUser, String nombreEvento) {
        this.fechaInscripcion = fechaInscripcion;
        this.nombreUser = nombreUser;
        this.nombreEvento = nombreEvento;
    }

    public InscripcionResponse() {
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

   

   
    
    
  
    
    
    

}
