package eventos.catalogos.infrastructure.config;

import eventos.catalogos.application.services.TaskService;
import eventos.catalogos.application.usercases.CreatedUseCaseImpl;
import eventos.catalogos.domain.ports.out.TaskRepositoryPort;
import eventos.catalogos.infrastructure.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort) {
        return new TaskService(
                new CreatedUseCaseImpl(taskRepositoryPort)
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

}
