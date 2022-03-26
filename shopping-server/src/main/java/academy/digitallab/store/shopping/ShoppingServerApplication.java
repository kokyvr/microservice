package academy.digitallab.store.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableEurekaClient
@EnableFeignClients
public class ShoppingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingServerApplication.class, args);
	}

}
