package MealPlan.Meal_Api;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private userService userService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody Map<String,String> user){
        return new ResponseEntity<User>(userService.createUser(user.get("username"),user.get("password"),user.get("email")),HttpStatus.CREATED);
}
@PostMapping("/login")
public ResponseEntity<User> loginUser(@RequestBody Map<String,String> user){
    

    return new ResponseEntity<User>(userService.checkUser(user.get("username"),user.get("password")),HttpStatus.OK);
}
@PostMapping("/addplan")
public ResponseEntity<Plan> addPlan(@RequestBody Map<String,String> user){
   
    return new ResponseEntity<Plan>(userService.addPlan(user.get("recipe"),user.get("days"),user.get("username")),HttpStatus.CREATED);

}

@PostMapping("/getplans")
public ResponseEntity<List<Plan>> getPlan(@RequestBody Map<String,String> user){
   

    return new ResponseEntity<List<Plan>>(userService.getPlan(user.get("days"),user.get("username")),HttpStatus.OK);

}

@GetMapping("/getlist/{user}")
public ResponseEntity<List<Item>> getlist(@PathVariable String user){
    return new ResponseEntity<List<Item>>(userService.getList(user),HttpStatus.OK);

}
}
