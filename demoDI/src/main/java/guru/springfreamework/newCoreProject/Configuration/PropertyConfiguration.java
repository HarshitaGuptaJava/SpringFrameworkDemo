package guru.springfreamework.newCoreProject.Configuration;

import guru.springfreamework.newCoreProject.ExampleBean.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:fakedatasource.properties")
public class PropertyConfiguration {

    @Value("${guru.username}")
    private String username;

    @Value("${guru.dburl}")
    private String url;

    @Value("${guru.password}")
    private String password;

    @Bean
    public FakeDataSource fakeDataSource(){

        FakeDataSource fakeDataSource=new FakeDataSource();
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        fakeDataSource.setUser(username);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;

    }
}
