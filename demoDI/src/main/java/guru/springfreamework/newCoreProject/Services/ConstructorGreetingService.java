package guru.springfreamework.newCoreProject.Services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {

    @Override
    public String sayHello() {
        return "Hello from Constructor Service";
    }
}
