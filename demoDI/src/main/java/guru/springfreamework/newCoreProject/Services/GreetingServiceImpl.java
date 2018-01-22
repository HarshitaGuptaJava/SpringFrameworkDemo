package guru.springfreamework.newCoreProject.Services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO ="Hello Gurus!!";
    public String sayHello(){

        return HELLO;

    }
}
