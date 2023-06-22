package re_gacha.mainlogic;

import java.util.Map;
import java.lang.RuntimeException;
import java.util.HashMap;
import java.util.stream.*;

public class Item {

    private static Item item; //자기 객체를 만들고 - 클래스 로딩시
    private Item() {} // 외부에서 생성자 접근 제한

    private Map<String, Integer> itemMap; // item객체의 itemMap type 지정

    public static Item createItem(Map<String,Integer> obj) throws RuntimeException{ //최초 생성 시
        
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
