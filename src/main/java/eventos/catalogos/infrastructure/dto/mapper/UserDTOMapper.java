package eventos.catalogos.infrastructure.dto.mapper;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.infrastructure.dto.CreateUserDTO;
import eventos.catalogos.infrastructure.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    public User toDomain(CreateUserDTO dto) {
        return new User(
                null, // ID se genera en el repositorio
                dto.getName(),
                dto.getEmail());
    }

    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail());
    }
}
