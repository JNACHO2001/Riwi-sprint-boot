package eventos.catalogos.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class EventRequest {

    @NotBlank(message = " es obligatorio el campo")
    private String nombre;
    @NotNull(message = " es obligatorio el campo")
    private LocalDate fechaEvento;
    @NotBlank(message = " es obligatorio el campo")
    private String ubicacion;
    
    @NotBlank(message = "no puede estar vacio")
    private String ciudad;

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
