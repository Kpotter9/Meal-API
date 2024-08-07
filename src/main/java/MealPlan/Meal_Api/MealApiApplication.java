package MealPlan.Meal_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MealApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealApiApplication.class, args);
	}
	

}
