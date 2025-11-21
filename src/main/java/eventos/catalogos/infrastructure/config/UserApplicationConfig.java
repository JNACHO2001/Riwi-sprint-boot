
package eventos.catalogos.infrastructure.config;

import eventos.catalogos.application.services.UserService;
import eventos.catalogos.application.usercases.CreateUserUseCaseImpl;
import eventos.catalogos.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserApplicationConfig {

    @Bean
    public UserService userService(UserRepositoryPort repo) {
        return new UserService(
                new CreateUserUseCaseImpl(repo)
        );
    }

}


