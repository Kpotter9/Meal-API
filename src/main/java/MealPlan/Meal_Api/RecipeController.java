package MealPlan.Meal_Api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
@RequestMapping("api/meals")
@CrossOrigin(origins ="*")
public class RecipeController {
    @Autowired
    private RecipeService RecipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> GetAllRecipes(){
        return new ResponseEntity<List<Recipe>>(RecipeService.AllRecipes(),HttpStatus.OK);

    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Recipe>> GetOneRecipe(@PathVariable String id){

        return new ResponseEntity<Optional<Recipe>>(RecipeService.OneRecipe(id),HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Recipe>> Search(@PathVariable String title){
        return new ResponseEntity<List<Recipe>>(RecipeService.Search(title),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Recipe> Add(@RequestBody  Map<String,String> toAdd){


        return new ResponseEntity<Recipe>(RecipeService.Add(toAdd.get("name"),toAdd.get("url"),toAdd.get("image"),toAdd.get("description"),toAdd.get("author"),toAdd.get("ingredients"),toAdd.get("steps"),toAdd.get("serves"),toAdd.get("nutrients"),toAdd.get("time"),toAdd.get("difficult")),HttpStatus.CREATED);

    }
}
