package guru.springfreamework.newCoreProject.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class PrimaryGreetingServiceSpanish implements GreetingService{
    GreetingRepository greetingRepository;

    public PrimaryGreetingServiceSpanish(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayHello() {
        return greetingRepository.getSpanishGreeting();
    }
}
