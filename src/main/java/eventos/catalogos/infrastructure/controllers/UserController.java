
package eventos.catalogos.infrastructure.controllers;

import eventos.catalogos.application.services.UserService;
import eventos.catalogos.domain.model.User;
import eventos.catalogos.infrastructure.entities.UserEntity;
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

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }
    
    @GetMapping("/{id}")
public ResponseEntity<UserEntity> buscarPorId(@PathVariable Long id) {
    
    var user = service.BuscarPorId(id);
    return ResponseEntity.ok(user);
}
  }
    
    
    
