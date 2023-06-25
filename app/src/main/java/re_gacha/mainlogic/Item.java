package re_gacha.mainlogic;

import java.util.Map;
import java.util.HashMap;
import re_gacha.mainlogic.ItemVertify;

public class Item {

    //private static Item item; //자기 객체를 만들고 - 클래스 로딩시
    private Item() {} // 외부에서 생성자 접근 제한

    private Map<String, Integer> itemMap; // item객체의 itemMap type 지정

    public Item(Map<String,Integer> obj) throws IllegalArgumentException, IllegalStateException{ //최초 생성 시
        
        if (obj.isEmpty()) { // obj 내부가 빈 값이 전달 되었을 경우
            throw new IllegalArgumentException("null Item은 생성할 수 없습니다.");
        }

        if (obj.values().stream().anyMatch(e->e<0)) { // 람다, 스트림씀- 0이하 1개라도 있을 경우 err
            throw new IllegalArgumentException("아이템은 음수일 수 없습니다.");
        }

        if (obj.values().stream().anyMatch(e-> e == Integer.MAX_VALUE)) { // int범위 벗어나면 max_vlaue로 변경 -> err
            throw new IllegalArgumentException("overflow가 입력되었습니다.");
        } 

        itemMap = new HashMap<>();
        itemMap.putAll(obj);

        /*
        if (item == null) { // item이 아직 생성 안되었을 경우
            item = new Item();
            item.itemMap = new HashMap<>();
            item.itemMap.putAll(obj);
        } else { // 이미 존재할 경우 에러 발생
            throw new IllegalStateException("Item객체를 중복생성 할 수 없습니다");
        }

        return item;
        */


    }
    
    
    public int getItemValue(String key) { // key에 해당하는 return value
        
        return itemMap.get(key);
    }
    

    public void incItem(String key, int value) throws IllegalArgumentException{ // item.itemMap에 이전값 + value 값

        ItemVertify.negativeError(value);
        int beforeValue = itemMap.get(key);

        ItemVertify.sumError(beforeValue, value);

        itemMap.put(key,beforeValue+value);
    }

    public void decItem(String key, int value) throws IllegalArgumentException { // item.itemMap에 이전값 - value 값

        ItemVertify.negativeError(value); // 음수 value?
        
        int beforeValue = itemMap.get(key);

        ItemVertify.subError(beforeValue, value); // 계산 후 음수?

        itemMap.put(key,beforeValue-value);

    }

    

    
}
