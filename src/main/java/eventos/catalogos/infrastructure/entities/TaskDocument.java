package eventos.catalogos.infrastructure.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class TaskDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private boolean completed;

    public TaskDocument() {
    }

    public TaskDocument(String id, String title, String description, LocalDate creationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
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

    

}
