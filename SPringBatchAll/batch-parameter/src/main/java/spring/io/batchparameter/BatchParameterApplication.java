package spring.io.batchparameter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchParameterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchParameterApplication.class, args);
	}
}
