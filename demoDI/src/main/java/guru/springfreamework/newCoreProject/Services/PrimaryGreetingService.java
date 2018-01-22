package guru.springfreamework.newCoreProject.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryGreetingService implements GreetingService {


    @Override
    public String sayHello() {
        return "Hello Primary Greeting Service";
    }
}
