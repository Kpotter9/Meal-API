package MealPlan.Meal_Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Item createItem(String item, String uname ){
        Item newItem = itemRepository.insert( new Item(item));
       

        mongoTemplate.update(User.class)
        .matching(Criteria.where("username").is(uname))
        .apply(new Update().push("itemIds").value(newItem)).first();
        return newItem;
        
    }


    public List<Item> createItems(String item, String uname) {

        List<String> items = Arrays.asList(item.split(",_"));
        List<Item> newItemsToAdd = new ArrayList<Item>();

        for (String string : items) {
            newItemsToAdd.add(new Item(string));
        }
        
        List<Item> newItems =itemRepository.insert(newItemsToAdd);
        mongoTemplate.update(User.class)
        .matching(Criteria.where("username").is(uname))
        .apply(new Update().push("itemIds").each(newItems)).first();

        return newItems;}


    public Item removeItem(String id, String uname) {
        
        Item item = (itemRepository.findById(new ObjectId(id)).get());
        mongoTemplate.upsert(new Query(Criteria.where("username").is(uname))

        ,new Update().pull("itemIds",new ObjectId(id)),User.class);
       itemRepository.delete(item);
       
        
       return item;

    }


    public Item getItem(String id) {
        return itemRepository.findById(new ObjectId(id)).get();
    }
}
