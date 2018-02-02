package guru.springfreamework.newCoreProject.Services;

public class GreetingServiceFactory {

    GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
//FactoryBean help in providing dependency injectiont runtime
    public GreetingService createGreetingService(String lang){
        switch (lang){
            case "en":
                return new PrimaryGreetingService(greetingRepository);

            case "es":
                return new PrimaryGreetingServiceSpanish(greetingRepository);
            default:
                return new PrimaryGreetingService(greetingRepository);
        }

   }
}
