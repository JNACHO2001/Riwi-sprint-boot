package eventos.catalogos.infrastructure.dto;

import java.time.LocalDate;

public class TaskResponseDTO {

    private String id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private boolean completed;
    private Long userId;

    public TaskResponseDTO() {
    }

    public TaskResponseDTO(String id, String title, String description,
            LocalDate creationDate, boolean completed, Long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
