package guru.springfreamework.newCoreProject.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyControllers {

    public String hello(){
        System.out.println("hello!!");
        return "Hello World";
    }
}
