package academy.digitallab.store.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShoppingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingServerApplication.class, args);
	}

}
