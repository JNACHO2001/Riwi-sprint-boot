package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public  TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
        );

    }

    public  Task toDomain(TaskEntity entity) {

        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreationDate(),
                entity.isCompleted()
        );

    }

}
