package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.infrastructure.entities.TaskDocument;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public  TaskDocument toEntity(Task task) {
        return new TaskDocument(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
        );

    }

    public  Task toDomain(TaskDocument entity) {

        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreationDate(),
                entity.isCompleted()
        );

    }

}
