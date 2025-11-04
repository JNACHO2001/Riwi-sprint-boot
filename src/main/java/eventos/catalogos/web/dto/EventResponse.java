package eventos.catalogos.web.dto;
import java.time.LocalDate;

public class EventResponse {
    
       private String nombre;
    private LocalDate fechaEvento;
     private String ubicacion;
     private String ciudad;

    public EventResponse(String nombre, LocalDate fechaEvento, String ubicacion, String ciudad) {
        this.nombre = nombre;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    

}
