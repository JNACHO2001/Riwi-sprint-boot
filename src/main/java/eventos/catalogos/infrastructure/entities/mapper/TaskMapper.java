package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.infrastructure.entities.TaskDocument;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDocument toEntity(Task task) {
        return new TaskDocument(task.getId(), task.getTitle(), task.getDescription(),
                task.getCreationDate(), task.isCompleted(), task.getUserId());
    }

    public Task toDomain(TaskDocument taskDocument) {

        if (taskDocument == null) {
            return null;
        }

        return new Task(
                taskDocument.getId(),
                taskDocument.getTitle(),
                taskDocument.getDescription(),
                taskDocument.getCreationDate(),
                taskDocument.isCompleted(),
                taskDocument.getUserId());

    }
}
