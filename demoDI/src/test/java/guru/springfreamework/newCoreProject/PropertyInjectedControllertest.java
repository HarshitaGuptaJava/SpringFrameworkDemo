package guru.springfreamework.newCoreProject;

import guru.springfreamework.newCoreProject.Services.GreetingService;
import guru.springfreamework.newCoreProject.Services.GreetingServiceImpl;
import guru.springfreamework.newCoreProject.controllers.PropertyGeneratedController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertyInjectedControllertest {

    private PropertyGeneratedController propertyGeneratedController;
@Before
    public void setUp(){

    this.propertyGeneratedController=new PropertyGeneratedController();
    this.propertyGeneratedController.greetingServiceImpl=new GreetingServiceImpl();
    }

@Test
    public void testGreeting()throws Exception{

    assertEquals(GreetingServiceImpl.HELLO,propertyGeneratedController.sayHello());

}

}
