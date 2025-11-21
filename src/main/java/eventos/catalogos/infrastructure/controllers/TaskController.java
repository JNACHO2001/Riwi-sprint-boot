
package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.application.services.TaskService;
import eventos.catalogos.domain.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createdTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    
    
    
    
    
    
}
