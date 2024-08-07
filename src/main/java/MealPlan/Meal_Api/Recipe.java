package MealPlan.Meal_Api;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection="recipes")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private String id;

    private String name;

    private String url;

    private int rattings;

    private String category;

    private String image;

    private String description;

    private String author;

    private List<String> ingredients;

    private List<String> steps;

    private int serves;

    private Object nutrients;

    private Object times;

    private String difficult;

    
}
