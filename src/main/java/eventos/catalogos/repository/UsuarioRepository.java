package eventos.catalogos.repository;

import eventos.catalogos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Integer> {
    
boolean existsByNombreIgnoreCase(String nombre);

    
}
