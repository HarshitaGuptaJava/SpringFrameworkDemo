package guru.springfreamework.newCoreProject.Services;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository{
    @Override
    public String getSpanishGreeting() {
        return "Greeting in Spanish";
    }

    @Override
    public String getEnglishGreeting() {
        return "Greeting in English";
    }

}
