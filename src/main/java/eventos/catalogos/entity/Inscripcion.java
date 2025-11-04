package eventos.catalogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;


@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate fechaInscripcion;
    
    @ManyToOne
    @JoinColumn(name = "evento_id",referencedColumnName = "id",  nullable = false)
    private Event event;
    
    
    @ManyToOne
    @JoinColumn(name = "participante_id",referencedColumnName = "id",nullable = false)
    private User user;

    public Inscripcion() {
    }
    
    

    public Inscripcion(LocalDate fechaInscripcion, Event event, User user) {
        this.fechaInscripcion = fechaInscripcion;
        this.event = event;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
