package guru.springfreamework.newCoreProject;

import guru.springfreamework.newCoreProject.Services.GreetingServiceImpl;
import guru.springfreamework.newCoreProject.controllers.ConstructedInjectedController;
import guru.springfreamework.newCoreProject.controllers.SetterGeneratedController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstruterGeneratedControllerTest {

    private ConstructedInjectedController constructedInjectedController;

    @Before
    public void setUp(){
        this.constructedInjectedController=new ConstructedInjectedController(new GreetingServiceImpl());


    }

    @Test
    public void testGreetings() throws Exception
    {
        assertEquals(GreetingServiceImpl.HELLO,constructedInjectedController.sayHello());
    }
}
