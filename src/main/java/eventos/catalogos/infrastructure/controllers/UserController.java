package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.domain.ports.in.UserUseCase;
import eventos.catalogos.infrastructure.dto.CreateUserDTO;
import eventos.catalogos.infrastructure.dto.UserResponseDTO;
import eventos.catalogos.infrastructure.dto.mapper.UserDTOMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserUseCase userUseCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(UserUseCase userUseCase, UserDTOMapper userDTOMapper) {
        this.userUseCase = userUseCase;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody CreateUserDTO dto) {
        // Convertir DTO a Domain
        User user = userDTOMapper.toDomain(dto);

        // Ejecutar caso de uso
        User createdUser = userUseCase.create(user);

        // Convertir Domain a DTO Response
        UserResponseDTO response = userDTOMapper.toResponse(createdUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        User user = userUseCase.BuscarPorId(id);
        UserResponseDTO response = userDTOMapper.toResponse(user);
        return ResponseEntity.ok(response);
    }
}
