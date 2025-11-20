package eventos.catalogos.infrastructure.entities.mapper;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.infrastructure.entities.UserDocument;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDocument toDocument(User user) {
        return new UserDocument(user.getId(), user.getName(), user.getEmail());
    }

    public User toDomain(UserDocument doc) {
        return new User(doc.getId(), doc.getName(), doc.getEmail());
    }
}
