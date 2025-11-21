package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toDocument(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getEmail());
    }

    public User toDomain(UserEntity doc) {
        return new User(doc.getId(), doc.getName(), doc.getEmail());
    }
}
