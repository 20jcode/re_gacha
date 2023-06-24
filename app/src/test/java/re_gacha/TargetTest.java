package re_gacha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.Target;

public class TargetTest {
    
    @Nested
    @DisplayName("타겟 생성")
    class CreateTargetTest{

        Target target = new Target("해피");


        @Test
        @DisplayName("타겟이 생성되는가?")
        void createTest(){

            String targetname = "tar1";
            Target t = new Target(targetname);


            assertNotNull(t);
        }

        @Test
        @DisplayName("타겟의 이름 조회")
        void nameTest(){

            assertEquals(target.getName(),"해피");
        }
    }

    @Nested
    @DisplayName("타켓의 제조법 지정")
    class SetTargetTest{

        Target target = new Target("해피");

        @Test
        @DisplayName("제조법 1개 추가,조회")
        void setKeyValueTest(){
            
            String key = "realstone";
            int value = 4;
            

            target.setRecipe(key,value);

            
            assertTrue(target.getRecipe().contains(key));
            System.out.println(target.getRecipe());

            assertEquals(target.getValue(key),value);
            
        }

        @Test
        @DisplayName("소비 item 지정")
        void useItemTest(){

            String key = "blacktiket";
            int value = -1;

            assertDoesNotThrow(()->target.setUseItem(key,value)); // 메소드가 동작해야함
            assertThrowsExactly(IllegalArgumentException.class,() -> target.setUseItem(key,1)); //양수 입력시 err

        }

        @Test
        @DisplayName("소비 item 조회")
        void getUseItemTest(){

            String key = "blacktiket";
            int value = -1;

            target.setUseItem(key, value);

            int getValue = target.getUseItem(key);

            assertEquals(value,getValue);

        }

        @Test
        @DisplayName("소비 item err")
        @Disabled
        void getUseItemErrorTest(){

            String key = "blacktiket";
            int value = -1;

            target.setUseItem(key, value);

            assertThrowsExactly(IllegalArgumentException.class, ()->target.getUseItem("key"), "아이템이 없습니다");
        }



            

        
    }
}
