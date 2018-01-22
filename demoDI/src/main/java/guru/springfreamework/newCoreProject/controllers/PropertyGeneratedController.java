package guru.springfreamework.newCoreProject.controllers;

import guru.springfreamework.newCoreProject.Services.GreetingService;
import guru.springfreamework.newCoreProject.Services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyGeneratedController {
    @Autowired
    @Qualifier("greetingServiceImpl")
    public GreetingService greetingServiceImpl;

    public String sayHello(){
        return greetingServiceImpl.sayHello();
    }

}
