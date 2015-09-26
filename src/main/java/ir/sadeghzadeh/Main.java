package ir.sadeghzadeh;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by reza.sadeqzadeh@gmail.com on 9/26/15.
 */

@EnableScheduling
@Configuration
@ComponentScan
@ImportResource("classpath:spring-config.xml")
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class);
    }

}
