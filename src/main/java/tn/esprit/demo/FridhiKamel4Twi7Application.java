package tn.esprit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy

public class FridhiKamel4Twi7Application {

	public static void main(String[] args) {
		SpringApplication.run(FridhiKamel4Twi7Application.class, args);
	}

}
