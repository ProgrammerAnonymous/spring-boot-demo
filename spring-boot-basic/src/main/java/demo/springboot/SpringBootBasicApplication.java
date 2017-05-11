package demo.springboot;

import java.util.Random;

import demo.springboot.sort.SortService;
import demo.springboot.sort.SortStats;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBasicApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootBasicApplication.class);
    private static final int SIZE = 100000;
    private static final int MAX_BOUND = 100000;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

    @Autowired
    private SortService service;

    @Bean
    public CommandLineRunner sortRunner() {
        return args -> {
            int[] instances = getRandomizedIntegers(SIZE);

            Pair<SortStats, int[]> results = service.sort(instances);

            log.info(results.getValue0().toString());
        };
    }

    private int[] getRandomizedIntegers(int size) {
        int[] instances = new int[size];

        Random rnd = new Random(System.currentTimeMillis());

        for (int i = 0; i < instances.length; i++) {
            instances[i] = rnd.nextInt(MAX_BOUND);
        }

        return instances;
    }
}
