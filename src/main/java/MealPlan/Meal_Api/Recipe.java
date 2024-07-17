package MealPlan.Meal_Api;

import java.util.List;

import org.bson.types.ObjectId;
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
    
    
    private String Name;

    private String url;

    private String Description;

    private String Author;

    private List<String> Ingredients;

    private List<String> Method;
    
}
