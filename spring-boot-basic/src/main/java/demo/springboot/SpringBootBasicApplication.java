package demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBasicApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringBootBasicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@Bean
	public CommandLineRunner sortRunner(){
		return args -> {
            log.info("display hello world in command line.");
        };
	}
}
