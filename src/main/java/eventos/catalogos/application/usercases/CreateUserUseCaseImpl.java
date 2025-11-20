package eventos.catalogos.application.usercases;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.domain.ports.in.UserUseCase;
import eventos.catalogos.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseImpl implements UserUseCase {

    private final UserRepositoryPort useRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort useRepositoryPort) {
        this.useRepositoryPort = useRepositoryPort;
    }

    @Override
    public User create(User user) {

        return useRepositoryPort.save(user);
    }

}
