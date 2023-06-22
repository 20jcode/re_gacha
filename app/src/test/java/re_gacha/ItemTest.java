package re_gacha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



import re_gacha.mainlogic.Item;

import java.util.Map;
import java.lang.RuntimeException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;


class ItemTest {

    private Item item;

    @Test
    @DisplayName("객체 생성 가능 확인")
    @Disabled // 싱글톤이라서 필요가 없음
    public void canItem(){
        //new Item();
    }
    
    @Nested
    @DisplayName("아이템 생성 시")
    class CreateItemTest{

        Map<String,Integer> defaultMapData;

        @BeforeEach
        void setUp(){
            //item = new Item();

            defaultMapData = new HashMap<>();
            defaultMapData.put("blacktiket",12);
            defaultMapData.put("redtiket",23);
            defaultMapData.put("money",1000);
        }

        @Test
        @DisplayName("아이템 정상 생성 확인")
        void inputItem(){ //아이템이 정상적으로 들어가는가

            // 삽입
            
            item = Item.createItem(defaultMapData);

            // 결과
            assertNotNull(item);

        }

        // @Test
        // void inputItemIsSame(){ //내가 넣은 값과 아이템이 같은가

        //     item.createItem(defaultMapData);

            
        // }

        @Test
        @DisplayName("빈 객체로 생성시 err 발생")
        void nullItemcheck(){ // 빈 map객체를 넣었을 때 err

            Map<String,Integer> nullMap = new HashMap<>();

           

            assertThrows(RuntimeException.class, () -> {
                Item.createItem(nullMap);
            });
        }

        @Test
        @DisplayName("이미 생성된 Item을 다시 생성")
        @Disabled // 굳이 이 테스트는 필요없다고 생각되어짐, 싱글톤?
        void repeatError(){ // 이미 create 한 상태에서 다시 create 시 err

            // Item.createItem(defaultMapData);

            // assertThrows(existItemException.class, () -> {
            //     Item.createItem(defaultMapData);
            // });
        }

        @Test
        @DisplayName("value가 음수인 값 넣을 시 err 발생")
        void negativeError(){ // value가 음수인 경우 err

            defaultMapData.clear();
            defaultMapData.put("나는 음수야",-200);

            assertThrows(RuntimeException.class, () -> {
                Item.createItem(defaultMapData);
            });
        }

        @Test
        @DisplayName("MAX_VALUE인 int값이 들어갈 경우, err 발생") // max값이라는 것은 이미 데이터 입력 시 int를 넘는 값이 들어간것
        void overflowError(){ // int범위를 넘은 value가 들어갈 경우

            defaultMapData.clear();
            defaultMapData.put("오버플로우발생",Integer.MAX_VALUE);

            assertThrows(RuntimeException.class, () -> {
                Item.createItem(defaultMapData);
            });
        }
    }


}
