package MealPlan.Meal_Api;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

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
    
    @TextIndexed(weight = 4) String name;

    private String url;

    private int rattings;

    private String category;

    private String image;

    @TextIndexed(weight = 2) String description;

    private String author;

    @TextIndexed(weight = 1)  List<String> ingredients;

    private List<String> steps;

    private int serves;

    private Object nutrients;

    private Object times;

    private String difficult;

    @TextScore Float score;

    public Recipe(String name, String url, String image, String description, String author, String ingredients, String steps, String serves, String nutrients, String times, String difficult) {
        this.name=name;
        this.url=url;
        this.image=image;
        this.description=description;
        this.author=author;
        this.ingredients=Arrays.asList(ingredients.split(",_"));
        this.steps=Arrays.asList(steps.split(",_"));
        try {
        this.serves=Integer.parseInt(serves);
    }catch(Exception e){
            this.serves=0;
        }
        

        try{
        this.nutrients=new nutrients(nutrients.split(",_"));
        }catch(Exception e){
            this.nutrients=null;
        }
        try{
        this.times=new times(times.split(",_"));}
        catch(Exception e){
            this.times=null;
        }
        this.difficult=difficult;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class times{
    String Preparation;
    String Cooking;
    public times(String[] timeList){
        Preparation=timeList[0];
        Cooking=timeList[1];
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class nutrients{
            String kcal;
            String fat;
            String saturates;
            String carbs;
            String sugars;
            String fibre;
            String protein;
            String salt;
            public nutrients(String[] nutrientsList){
                
                kcal=nutrientsList[0];
                fat=nutrientsList[1];
                saturates=nutrientsList[2];
                carbs=nutrientsList[3];
                sugars=nutrientsList[4];
                fibre=nutrientsList[5];
                protein=nutrientsList[6];
                salt=nutrientsList[7];
            }
        }