package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.domain.ports.out.UserRepositoryPort;
import eventos.catalogos.infrastructure.entities.mapper.UserMapper;
import java.util.List;
import org.springframework.stereotype.Component;



@Component
public class MongoUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringUserMongoRepository repo;
    private final UserMapper userMapper;

    public MongoUserRepositoryAdapter(SpringUserMongoRepository repo, UserMapper userMapper) {
        this.repo = repo;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {

        var document = userMapper.toDocument(user);
        var comvertida = repo.save(document);

        return userMapper.toDomain(comvertida);

    }

    @Override
    public User findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
