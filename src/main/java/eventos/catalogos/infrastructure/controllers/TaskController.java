package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.domain.ports.in.TaskUseCase;
import eventos.catalogos.infrastructure.dto.CreateTaskDTO;
import eventos.catalogos.infrastructure.dto.TaskResponseDTO;
import eventos.catalogos.infrastructure.dto.mapper.TaskDTOMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskUseCase taskUseCase;
    private final TaskDTOMapper taskDTOMapper;

    public TaskController(TaskUseCase taskUseCase, TaskDTOMapper taskDTOMapper) {
        this.taskUseCase = taskUseCase;
        this.taskDTOMapper = taskDTOMapper;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody CreateTaskDTO dto) {
        // Convertir DTO a Domain
        Task task = taskDTOMapper.toDomain(dto);

        // Ejecutar caso de uso
        Task createdTask = taskUseCase.createdTask(task);

        // Convertir Domain a DTO Response
        TaskResponseDTO response = taskDTOMapper.toResponse(createdTask);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
