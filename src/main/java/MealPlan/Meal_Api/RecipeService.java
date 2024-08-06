package MealPlan.Meal_Api;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder;
import org.springframework.data.mongodb.core.query.TextCriteria;
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

    
    public List<Recipe> Search(String title) {
        
        Sort sort = Sort.by("score");
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(title.split("_"));
        return recipeRepository.findAllBy(criteria,sort);
    }
    public Recipe Add(String name, String url, String image, String description, String author, String ingredients, String steps, String serves, String nutrients, String times, String difficult){
        Recipe recipe = new Recipe(name, url, image, description, author, ingredients, steps, serves, nutrients, times, difficult);
        return this.recipeRepository.insert(recipe);
    }
}
