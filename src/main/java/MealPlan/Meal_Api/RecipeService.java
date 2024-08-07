package MealPlan.Meal_Api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> AllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> OneRecipe(String id) {
        return recipeRepository.getRecipeById(id);
    }

}
