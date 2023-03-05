package projeto.jpa.lcsports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LcsportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcsportsApplication.class, args);
    }

}
