package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

}
