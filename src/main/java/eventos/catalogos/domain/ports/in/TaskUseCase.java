package eventos.catalogos.domain.ports.in;

import eventos.catalogos.domain.model.Task;

public interface TaskUseCase {

    Task createdTask(Task task);

}
