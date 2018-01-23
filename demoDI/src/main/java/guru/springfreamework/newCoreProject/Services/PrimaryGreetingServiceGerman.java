package guru.springfreamework.newCoreProject.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"en","default"})//default is used when there is no active profile
public class PrimaryGreetingServiceGerman implements GreetingService {

    @Override
    public String sayHello() {
        return "Primary service German";
    }
}
