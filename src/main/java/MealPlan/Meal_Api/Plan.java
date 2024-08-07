package MealPlan.Meal_Api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Plan{
        private List<Recipe> recipe;
        private String date;
        private String day;


        public Plan(Recipe recipe, int days){
            this.recipe = new ArrayList<Recipe>();
            this.recipe.add(recipe);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE,days);
            this.date = sdf.format(c.getTime());

            int count = c.get(Calendar.DAY_OF_WEEK);
            switch (count) {
                case 1:
                    this.day = "Sunday";
                    break;
                case 2:
                    this.day = "Monday";
                    break;
                case 3:
                    this.day = "Tuesday";
                    break;
                case 4:
                    this.day = "Wednesday";
                    break;
                case 5:
                    this.day = "Thursday";
                    break;
                case 6:
                    this.day = "Friday";
                    break;
                case 7:
                    this.day = "Saturday";
                    break;
    

        }
       
    }}
