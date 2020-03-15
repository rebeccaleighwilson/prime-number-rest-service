package rbscodingtest.primenumberrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PrimesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimesApplication.class, args);
    }

}
