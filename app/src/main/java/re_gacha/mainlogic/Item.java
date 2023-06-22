package re_gacha.mainlogic;

import java.util.Map;
import java.util.HashMap;

public class Item {

    private static Item item; //자기 객체를 만들고 - 클래스 로딩시
    private Item() {} // 외부에서 생성자 접근 제한

    private Map<String, Integer> itemMap; // item객체의 itemMap type 지정

    public static Item createItem(Map<String,Integer> obj) { //최초 생성 시
        
        if (item == null) {
            item = new Item();
            item.itemMap = new HashMap<>();

            item.itemMap.putAll(obj);
        }

        return item;


    }
    
    public void addItem(String item, int value) { //새로운 아이템 추가
        itemMap.put(item,value);
    }

    public void decItem(String item, int itemvalue) {

    }

    public int getItem(String item) { //현재 아이템의 남은 수량 확인
        return itemMap.get(item);
    }

    

    
}
