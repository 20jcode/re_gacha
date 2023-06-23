package re_gacha.mainlogic;

import java.util.Map;
import java.lang.RuntimeException;
import java.util.HashMap;
import java.util.stream.*;

public class Item {

    private static Item item; //자기 객체를 만들고 - 클래스 로딩시
    private Item() {} // 외부에서 생성자 접근 제한

    private Map<String, Integer> itemMap; // item객체의 itemMap type 지정

    public static Item createItem(Map<String,Integer> obj) throws RuntimeException, IllegalStateException{ //최초 생성 시
        
        if (obj.isEmpty()) { // obj 내부가 빈 값이 전달 되었을 경우
            throw new RuntimeException("null Item은 생성할 수 없습니다.");
        }

        if (obj.values().stream().anyMatch(e->e<0)) { // 람다, 스트림씀- 0이하 1개라도 있을 경우 err
            throw new RuntimeException("아이템은 음수일 수 없습니다.");
        }

        if (obj.values().stream().anyMatch(e-> e == Integer.MAX_VALUE)) { // int범위 벗어나면 max_vlaue로 변경 -> err
            throw new RuntimeException("overflow가 입력되었습니다.");
        } 



        
        if (item == null) { // item이 아직 생성 안되었을 경우
            item = new Item();
            item.itemMap = new HashMap<>();
            item.itemMap.putAll(obj);
        } else { // 이미 존재할 경우 에러 발생
            throw new IllegalStateException("Item객체를 중복생성 할 수 없습니다");
        }

        return item;


    }

    public static void resetItem(){ //테스트를 위해, item을 null로 설정. 다시 createItem할 수 있도록

        item = null;
    }
    
    public int getItemValue(String key) {
        
        return item.itemMap.get(key);
    }

    public void incItem(String key, int value) { // item.itemMap에 이전값 + value 값

        int beforeValue = item.itemMap.get(key);
        item.itemMap.put(key,beforeValue+value);
    }

    public void decItem(String key, int value) { // item.itemMap에 이전값 - value 값

        int beforeValue = item.itemMap.get(key);
        item.itemMap.put(key,beforeValue-value);

    }

    

    
}
