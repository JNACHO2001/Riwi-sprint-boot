package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.infrastructure.entities.TaskEntity;

public class TaskMapper {

    public static TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
        );

    }

    public static Task toDomain(TaskEntity entity) {

        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreationDate(),
                entity.isCompleted()
        );

    }

}
