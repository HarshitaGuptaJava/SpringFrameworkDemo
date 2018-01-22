package guru.springfreamework.newCoreProject;

import guru.springfreamework.newCoreProject.Services.GreetingService;
import guru.springfreamework.newCoreProject.Services.GreetingServiceImpl;
import guru.springfreamework.newCoreProject.controllers.SetterGeneratedController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetterInjectedControllerTest {
    private SetterGeneratedController setterGeneratedController;

    @Before
    public void setUp(){
        this.setterGeneratedController=new SetterGeneratedController();
        this.setterGeneratedController.setGreetingService(new GreetingServiceImpl());


    }

    @Test
    public void testGreetings() throws Exception
    {
        assertEquals(GreetingServiceImpl.HELLO,setterGeneratedController.sayHello());
    }
}
