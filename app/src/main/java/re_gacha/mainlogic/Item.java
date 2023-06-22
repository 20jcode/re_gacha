package re_gacha.mainlogic;

import java.util.Map;
import java.util.HashMap;

public class Item {
    
    public void createItem(Map<String,Integer> obj) {

    }
    
    public void addItem(String item, int value) { //새로운 아이템 추가
        itemMap.put(item,value);
    }

    public void decItem(String item, int itemvalue) {

    }

    public int getItem(String item) { //현재 아이템의 남은 수량 확인
        return itemMap.get(item);
    }

    private Map<String, Integer> itemMap;

    public Item() {
        itemMap = new HashMap<>();
    }

}
