package MealPlan.Meal_Api;

import java.util.List;

import org.bson.types.ObjectId;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;



@Service
public class userService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    private StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
    @Autowired
    private RecipeService recipeService;



    public User createUser(String user, String password, String email) {
       if(this.userRepository.findByUsername(user).isPresent()){
        throw new RuntimeException("User already exists");
       }else if(this.userRepository.findByEmail(email).isPresent()){
        throw new RuntimeException("Email already in use");
       }
       password=encryptor.encryptPassword(password);


       User newUser=this.userRepository.insert(new User(user, password, email));

       return newUser;
}       
    public User checkUser(String user, String password ){
        if(this.userRepository.findByUsername(user).isPresent()){
            User userFound=this.userRepository.findByUsername(user).get();
            Boolean check=encryptor.checkPassword(password,userFound.getPassword());
             if (check){
                return userFound;
            }
        }
        throw new RuntimeException("Invalid username or password");


    }
    public Plan addPlan(String recipe, String days, String user) {
        
<<<<<<< HEAD
=======
        
>>>>>>> parent of 896dfb2 ( commit)
            Plan plan= new Plan(recipeService.OneRecipe(recipe).get(),Integer.parseInt(days));
            mongoTemplate.update(User.class)
                        .matching(Criteria.where("username").is(user))
                        .apply(new Update().push("plans").value(plan))
                        .first();
            return plan;
            
        
        
    }
    public List<Plan> getPlan(String days,String user) {
       
      

        int count=Integer.parseInt(days);
        
        User userFound=this.userRepository.findByUsername(user).get();
       
        List<Plan> plans=userFound.getPlans(count);
        


        return plans;
    }
    public List<Item> getList(String user){
        User userFound=this.userRepository.findByUsername(user).get();
        return userFound.getItemIds();
    }
}
