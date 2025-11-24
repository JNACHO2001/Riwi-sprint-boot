package eventos.catalogos.domain.ports.in;

import eventos.catalogos.domain.model.Task;
import java.util.List;


public interface TaskUseCase {

    Task createdTask(Task task);

    List<Task> getAllsTask();

}
