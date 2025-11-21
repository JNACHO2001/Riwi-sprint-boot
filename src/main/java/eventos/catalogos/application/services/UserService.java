package eventos.catalogos.application.services;

import eventos.catalogos.domain.model.User;
import eventos.catalogos.domain.ports.in.UserUseCase;

public class UserService implements UserUseCase {

    private final UserUseCase userUseCase;

    public UserService(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public User create(User user) {

        return userUseCase.create(user);

    }

    @Override
    public User BuscarPorId(Long id) {
        return userUseCase.BuscarPorId(id);
    }

}
