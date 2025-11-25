package eventos.catalogos.infrastructure.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime date;
    private String status;

    @Column(name = "venue_id")
    private String venueId; // Storing ID as String/VARCHAR

    public EventEntity() {
    }

    public EventEntity(Long id, String name, LocalDateTime date, String status, String venueId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.venueId = venueId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }
}
