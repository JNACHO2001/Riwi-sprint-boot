package eventos.catalogos.web.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class InscrpcionRequest {
      @NotNull(message = "el campo no puede estar vacio")
    private LocalDate fechaIncripcion;
    @NotNull(message = "el campo no puede estar vacio")
    private Integer user;
    @NotNull(message = "el campo no puede estar vacio")
    private Integer event;

    public LocalDate getFechaIncripcion() {
        return fechaIncripcion;
    }

    public void setFechaIncripcion(LocalDate fechaIncripcion) {
        this.fechaIncripcion = fechaIncripcion;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
    }

  
    

}
