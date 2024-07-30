package MealPlan.Meal_Api;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String password;
    private String email;
    private List<Plan> plans;


    public User(String username, String password, String email){
        this.username = username;
        this.password =  password;
        this.email = email;
        plans = new ArrayList<Plan>();
        
        
    }
   
    String getPassword(){
        return this.password;
    }
    @Data
    class Plan{
        private Recipe recipe;
        private String date;

        public Plan(Recipe recipe, int days){
            this.recipe = recipe;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE,days);
            this.date = sdf.format(c.getTime());

        }
       
    }

    

}
