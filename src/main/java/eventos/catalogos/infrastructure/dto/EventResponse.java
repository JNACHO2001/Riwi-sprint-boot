package eventos.catalogos.infrastructure.dto;

import java.time.LocalDateTime;

public class EventResponse {
    private Long id;
    private String name;
    private LocalDateTime date;
    private String status;
    private String venueId;

    public EventResponse() {
    }

    public EventResponse(Long id, String name, LocalDateTime date, String status, String venueId) {
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
