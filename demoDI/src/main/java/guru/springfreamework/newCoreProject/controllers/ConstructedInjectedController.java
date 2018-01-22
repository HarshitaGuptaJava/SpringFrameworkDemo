package guru.springfreamework.newCoreProject.controllers;

import guru.springfreamework.newCoreProject.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructedInjectedController {
@Autowired
    private GreetingService greetingService;

    public ConstructedInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayHello();

    }
}
