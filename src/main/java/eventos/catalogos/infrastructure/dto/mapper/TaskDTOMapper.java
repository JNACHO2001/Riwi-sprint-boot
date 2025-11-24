package eventos.catalogos.infrastructure.dto.mapper;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.infrastructure.dto.CreateTaskDTO;
import eventos.catalogos.infrastructure.dto.TaskResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskDTOMapper {

    public Task toDomain(CreateTaskDTO dto) {
        return new Task(
                null, // ID se genera en el repositorio
                dto.getTitle(),
                dto.getDescription(),
                LocalDate.now(),
                dto.isCompleted(),
                dto.getUserId());
    }

    public TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted(),
                task.getUserId());
    }
}
