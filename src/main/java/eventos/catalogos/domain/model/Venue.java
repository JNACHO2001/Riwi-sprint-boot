package eventos.catalogos.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Venue {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private List<Event> events = new ArrayList<>();

    public Venue() {
    }

    public Venue(Long id, String name, String location, Integer capacity, List<Event> events) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.events = events;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
