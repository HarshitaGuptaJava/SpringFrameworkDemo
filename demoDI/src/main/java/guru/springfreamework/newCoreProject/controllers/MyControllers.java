package guru.springfreamework.newCoreProject.controllers;

import guru.springfreamework.newCoreProject.Services.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

@Controller
public class MyControllers {

   private GreetingService greetingService;

    public MyControllers(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("hello!!");
        return greetingService.sayHello();
    }
}
