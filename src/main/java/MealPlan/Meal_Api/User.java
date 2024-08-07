package MealPlan.Meal_Api;
import org.springframework.data.mongodb.core.mapping.Document;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private List<Item> itemIds; 


    public User(String username, String password, String email){
        this.username = username;
        this.password =  password;
        this.email = email;
        plans = new ArrayList<Plan>();
        itemIds=new ArrayList<Item>(); 

        
        
    }
   
    String getPassword(){
        return this.password;
    }

    public List<Plan> getPlans(int days) {
        List<Plan> plansForDays = new ArrayList<Plan>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,days);
        String date = sdf.format(c.getTime());

        for(int i=0;i<plans.size();i++){
            if(date.equals(plans.get(i).getDate())){
                plansForDays.add(plans.get(i));
            }
    }
    return plansForDays;
}

    public List<Item> geiItemIds() {
        return this.itemIds;
    }
    

    

}
