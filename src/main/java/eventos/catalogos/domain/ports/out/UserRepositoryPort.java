
package eventos.catalogos.domain.ports.out;

import eventos.catalogos.domain.model.User;
import java.util.List;

public interface UserRepositoryPort {
    
    
    User save(User user);

    User findById(String id);

    List<User> findAll();
    
    
}
