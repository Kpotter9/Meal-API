package MealPlan.Meal_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class MealApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealApiApplication.class, args);
	}
	

}
