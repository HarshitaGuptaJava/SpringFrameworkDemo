package spring.io.batchparameter.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.TaskletStepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;


//stepScope is used to add parameter so the tasklet is instantiated when step is started
    @Bean
    @StepScope
    public Tasklet helloTasklet(@Value("#{JobParameters['message']}")String message){
       return new Tasklet() {
           @Override
           public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
               System.out.println(message);
               return RepeatStatus.FINISHED;
           }
       };
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1").tasklet(helloTasklet(null)).build();
    }
    @Bean
    public Job paramJob()
    {
        return jobBuilderFactory.get("paramJob").start(step1())
                .build();


    }
}
