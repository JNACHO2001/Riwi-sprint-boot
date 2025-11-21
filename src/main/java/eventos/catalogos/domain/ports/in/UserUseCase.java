
package eventos.catalogos.domain.ports.in;

import eventos.catalogos.domain.model.User;


public interface UserUseCase {
     User create(User user);
     
     User BuscarPorId(Long id);
    
}
