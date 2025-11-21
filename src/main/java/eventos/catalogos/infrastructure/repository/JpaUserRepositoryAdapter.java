package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.domain.ports.out.UserRepositoryPort;
import eventos.catalogos.infrastructure.entities.mapper.UserMapper;
import java.util.List;
import org.springframework.stereotype.Component;



@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository repo;
    private final UserMapper userMapper;

    public JpaUserRepositoryAdapter(JpaUserRepository repo, UserMapper userMapper) {
        this.repo = repo;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {

        var entity= userMapper.toDocument(user);
        var comvertida = repo.save(entity);

        return userMapper.toDomain(comvertida);

    }

    @Override
    public User findById(Long id) {
        return repo.findById(id)
                .map(userMapper::toDomain)
                .orElseThrow(()-> new  RuntimeException("No se encontro el usuario") );
        
        
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
