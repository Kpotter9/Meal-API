package MealPlan.Meal_Api;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item,ObjectId> {

    @SuppressWarnings("null")
    Optional<Item> findById(ObjectId id);

}
