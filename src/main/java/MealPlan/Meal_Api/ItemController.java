package MealPlan.Meal_Api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Map<String,String> info) {
        return new ResponseEntity<Item>(itemService.createItem(info.get("item"), info.get("uname")),HttpStatus.CREATED);
    }
    @PostMapping("addlist")
    public ResponseEntity<List<Item>> addItems(@RequestBody Map<String,String> info) {
        return new ResponseEntity<List<Item>>(itemService.createItems(info.get("item"), info.get("uname")),HttpStatus.CREATED);
    }
    @PostMapping("/remove")
    public ResponseEntity<Item> removeItem(@RequestBody Map<String,String> info) {
        return new ResponseEntity<Item>(itemService.removeItem(info.get("id"), info.get("uname")), HttpStatus.OK);
    }
    @PostMapping("/get")
    public ResponseEntity<Item> getItem(@RequestBody Map<String,String> info) {
        return new ResponseEntity<Item>(itemService.getItem(info.get("id")), HttpStatus.OK);
    }

}

