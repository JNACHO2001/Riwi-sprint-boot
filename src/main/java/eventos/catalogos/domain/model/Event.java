package eventos.catalogos.domain.model;

import java.time.LocalDateTime;

public class Event {
    private Long id;
    private String name;
    private LocalDateTime date;
    private String status; // ACTIVE, CANCELLED
    private Venue venue;

    public Event() {
    }

    public Event(Long id, String name, LocalDateTime date, String status, Venue venue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
