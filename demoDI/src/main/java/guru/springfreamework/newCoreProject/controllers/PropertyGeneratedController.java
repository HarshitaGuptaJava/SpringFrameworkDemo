package guru.springfreamework.newCoreProject.controllers;

import guru.springfreamework.newCoreProject.Services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyGeneratedController {
    @Autowired
    public GreetingServiceImpl greetingServiceImpl;

    public String sayHello(){
        return greetingServiceImpl.sayHello();
    }

}
