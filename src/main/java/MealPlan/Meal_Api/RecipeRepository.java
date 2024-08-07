package MealPlan.Meal_Api;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe,ObjectId>{
    
    Optional<Recipe> getRecipeById(String id);

    List<Recipe> findByNameLike(String title);

    List<Recipe> findAllBy(TextCriteria criteria, Sort sort);

   

}
