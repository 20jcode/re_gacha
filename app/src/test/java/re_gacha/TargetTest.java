package re_gacha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
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
        @DisplayName("제조법 여러개 추가하기") //필요없을듯?
        void multiSetTest(){

        }

        

            

        
    }
}
