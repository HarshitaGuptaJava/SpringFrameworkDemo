package guru.springfreamework.newCoreProject.Services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

    @Override
    public String sayHello() {
        return "Hello from Setter Service";
    }
}
