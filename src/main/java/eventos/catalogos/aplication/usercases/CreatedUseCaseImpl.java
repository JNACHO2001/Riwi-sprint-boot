package eventos.catalogos.aplication.usercases;

import eventos.catalogos.domain.model.Task;
import eventos.catalogos.domain.ports.in.TaskUseCase;
import eventos.catalogos.domain.ports.out.TaskRepositoryPort;

import java.util.List;

public class CreatedUseCaseImpl implements TaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreatedUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createdTask(Task task) {

        return taskRepositoryPort.save(task);

    }

    @Override
    public List<Task> getAllsTask() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
