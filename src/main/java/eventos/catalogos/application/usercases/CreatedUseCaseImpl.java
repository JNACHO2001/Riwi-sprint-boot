package eventos.catalogos.application.usercases;

import eventos.catalogos.domain.exceptions.InvalidTaskException;
import eventos.catalogos.domain.model.Task;
import eventos.catalogos.domain.ports.in.TaskUseCase;
import eventos.catalogos.domain.ports.out.TaskRepositoryPort;
import eventos.catalogos.domain.ports.out.UserRepositoryPort;

import java.util.List;

public class CreatedUseCaseImpl implements TaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    public CreatedUseCaseImpl(TaskRepositoryPort taskRepositoryPort, UserRepositoryPort userRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Task createdTask(Task task) {

        // Validar que el userId no sea null
        if (task.getUserId() == null) {
            throw new InvalidTaskException("El userId no puede ser null. Toda tarea debe estar asociada a un usuario.");
        }

        // Verificar que el usuario existe (lanzará UserNotFoundException si no existe)
        userRepositoryPort.findById(task.getUserId());

        return taskRepositoryPort.save(task);

    }

    @Override
    public List<Task> getAllsTask() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
