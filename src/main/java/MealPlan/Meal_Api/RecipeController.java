package MealPlan.Meal_Api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
