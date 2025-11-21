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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private VenueEntity venue;

    public EventEntity() {
    }

    public EventEntity(Long id, String name, LocalDateTime date, VenueEntity venue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
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

    public VenueEntity getVenue() {
        return venue;
    }

    public void setVenue(VenueEntity venue) {
        this.venue = venue;
    }
}
