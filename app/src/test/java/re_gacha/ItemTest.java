package re_gacha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



import re_gacha.mainlogic.Item;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;


class ItemTest {

    private Item item;

    @Test
    @DisplayName("객체 생성 가능 확인")
    public void canItem(){
        new Item();
    }
    
    @Nested
    @DisplayName("아이템 생성 시")
    class CreateItemTest{

        Map<String,Integer> defaultMapData;

        @BeforeEach
        void setUp(){
            item = new Item();

            defaultMapData = new HashMap<>();
            defaultMapData.put("blacktiket",12);
            defaultMapData.put("redtiket",23);
            defaultMapData.put("money",1000);
        }

        @Test
        void inputItem(){ //아이템이 정상적으로 들어가는가

            // 삽입
            item.createItem(defaultMapData);

            // 결과
            assertNotNull(item);

        }

        // @Test
        // void inputItemIsSame(){ //내가 넣은 값과 아이템이 같은가

        //     item.createItem(defaultMapData);

            
        // }

        @Test
        void nullItemcheck(){ // 빈 map객체를 넣었을 때 err

            Map<String,Integer> nullMap = new HashMap<>();

           

            assertThrows(nullIteminputException.class, () -> {
                item.createItem(nullMap);
            });
        }

        @Test
        void repeatError(){ // 이미 create 한 상태에서 다시 create 시 err

            item.createItem(defaultMapData);

            assertThrows(existItemException.class, () -> {
                item.createItem(defaultMapData);
            });
        }

        @Test
        void negativeError(){ // value가 음수인 경우 err

            defaultMapData.clear();
            defaultMapData.put("나는 음수야",-200);

            assertThorws(neativeItemValueException.class, () -> {
                item.createItem(defaultMapData);
            });
        }

        @Test
        void overflowError(){ // int범위를 넘은 value가 들어갈 경우

            defaultMapData.clear();
            defaultMapData.put("오버플로우발생",Integer.MAX_VALUE);

            assertThrows(overflowException.class, () -> {
                item.createItem(defaultMapData);
            });
        }
    }


}
