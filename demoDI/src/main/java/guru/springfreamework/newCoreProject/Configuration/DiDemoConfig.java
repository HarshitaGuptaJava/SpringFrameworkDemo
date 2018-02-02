package guru.springfreamework.newCoreProject.Configuration;

import guru.springfreamework.newCoreProject.Services.GreetingRepository;
import guru.springfreamework.newCoreProject.Services.GreetingService;
import guru.springfreamework.newCoreProject.Services.GreetingServiceFactory;
import guru.springfreamework.newCoreProject.Services.PrimaryGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class DiDemoConfig {
@Bean
    public GreetingServiceFactory greetingServiceFactory(GreetingRepository repository){
    return new GreetingServiceFactory(repository);
    }

    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile("es")
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("es");
    }


}
