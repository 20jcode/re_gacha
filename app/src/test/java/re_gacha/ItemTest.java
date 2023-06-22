package re_gacha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import re_gacha.mainlogic.Item;

import java.util.Map;
import java.util.HashMap;


public class ItemTest {
    Item item = new Item();

    @Test //정상적으로 아이템이 추가되는가?
    void addItemTest(){
        String itemname = "블랙티켓";
        int value = 10;

        item.addItem(itemname,value);

        assertNotNull(item,"not null");
        
    }
    @Test // createItem() 에 대해서
    void createItemTest(){
        Map<String, Integer> itemMaptest = new HashMap<>();
        
        // test데이터 입력
        itemMaptest.put("블랙티켓",3);
        itemMaptest.put("경비",12);

        item.createItem(itemMaptest);
        
    }

}
