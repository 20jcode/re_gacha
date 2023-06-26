package re_gacha;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.Gacha;
import re_gacha.mainlogic.Target;
import re_gacha.mainlogic.Item;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

@Deprecated
public class GachaTest {

    Target target = new Target("happy");
    Target target2 = new Target("blacktiket");
    Item item;
    Map<String,Integer> defaultMap;
    

    @Nested
    public class GachaoneTest {

        @BeforeEach
        void setUp() {
            target.setRecipe("realstone", 4);
            target.setRecipe("gack", 1);
            target.setUseItem("blacktiket",1);
            target2.setRecipe("blacktiket",1);
           

        }

        
        @Test
        @DisplayName("뽑혔는가")
        void oneGachaTest(){

            
            double f = 0.0012f;

            assertInstanceOf(Boolean.class, Gacha.oneGacha(f));
            assertTrue(Gacha.oneGacha(1));
        }

        @Test
        @DisplayName("뽑기확률이 0일때")
        @RepeatedTest(1000)
        void zeroGachaTest(){

            assertFalse(Gacha.oneGacha(0));
        }


        
    }


    @Nested
    @Disabled
    public class ReadyForGachaTest {

        @BeforeEach
        @DisplayName("기본 Gacha 세팅")
        void setUp() {

        }

        @Test
        @DisplayName("Target의 레시피 얻기")
        void getRecipeTest(){

            
            HashSet<String> itemnames = new HashSet<>(target.getRecipe()); // target의 레시피를 얻음

            

            



        }

        
    }
/*
    @Nested
    public class GachaMainTest {

        @Test
        @DisplayName("가챠 전체 Test")
        void allTest(){

            Gacha gacha = new Gacha();
            item = Item.createItem(defaultMap);

            

        }
    }

    @Nested
    public class GachaLogicTest {

        Gacha gacha = new Gacha();

        @BeforeEach
        @DisplayName("Gacha 생성")
        void setUp(){
            item = Item.createItem(defaultMap);
        }

        @AfterEach
        void cleanUp(){
            Item.resetItem();
        }

        @Test
        @DisplayName("input 확률, return 뽑기결과")
        void isGachaTest(){

            double per = 0.012f;

            boolean ans = gacha.dogacha(per);

            assertNotNull(ans);
        }

        @Test
        @DisplayName("뽑기 횟수가 천장인가?")
        void isLimit(){

        }
    }

*/
}
