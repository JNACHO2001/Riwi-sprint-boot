
package eventos.catalogos.aplication.services;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.domain.ports.in.TaskUseCase;
import java.util.List;


public class TaskService  implements TaskUseCase{
    private final TaskUseCase taskUseCase;

    public TaskService(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }
    
    
    

    @Override
    public Task createdTask(Task task) {
        return taskUseCase.createdTask(task);
    }

    @Override
    public List<Task> getAllsTask() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
