package re_gacha.mainlogic;

import java.util.Map;
import java.util.HashMap;

public class Item {
    public void AddItem(String item, int value) {
        itemMap.put(item,value);
    }

    public void changeItem(String item, int itemvalue) {

    }

    public int getItem(String item) {
        return itemMap.get(item);
    }

    private Map<String, Integer> itemMap;

    public Item() {
        itemMap = new HashMap<>();
    }

}
