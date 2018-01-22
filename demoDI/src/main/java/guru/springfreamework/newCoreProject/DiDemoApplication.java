package guru.springfreamework.newCoreProject;

import com.sun.org.apache.xpath.internal.SourceTree;
import guru.springfreamework.newCoreProject.controllers.ConstructedInjectedController;
import guru.springfreamework.newCoreProject.controllers.MyControllers;
import guru.springfreamework.newCoreProject.controllers.PropertyGeneratedController;
import guru.springfreamework.newCoreProject.controllers.SetterGeneratedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=		SpringApplication.run(DiDemoApplication.class, args);
		MyControllers controllers=(MyControllers)ctx.getBean("myControllers");
		System.out.println(controllers.hello());

		PropertyGeneratedController propertyGeneratedController=(PropertyGeneratedController)ctx.getBean("propertyGeneratedController");
		System.out.println(propertyGeneratedController.sayHello());

		SetterGeneratedController setterGeneratedController=(SetterGeneratedController)ctx.getBean("setterGeneratedController");
		System.out.println(setterGeneratedController.sayHello());

		ConstructedInjectedController constructedInjectedController=(ConstructedInjectedController)ctx.getBean("constructedInjectedController");
		System.out.println(constructedInjectedController.sayHello());
	}
}
