package MealPlan.Meal_Api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Field(targetType=FieldType.OBJECT_ID)
    private String id;
    
    private String item;

    public Item( String item) {
        this.item = item;
    }
}
