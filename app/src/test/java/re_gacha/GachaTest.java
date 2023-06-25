package re_gacha;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.Gacha;
import re_gacha.mainlogic.Target;
import re_gacha.mainlogic.Item;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

public class GachaTest {

    Target target = new Target("happy");
    Item item;
    Map<String,Integer> defaultMap;
    

    @Nested
    public class GachaoneTest {

        @BeforeEach
        void setUp() {
            target.setRecipe("realstone", 4);
            target.setRecipe("gack", 1);
            item = Item.createItem(defaultMap);

        }

        @AfterEach
        void cleanUp(){
            Item.resetItem();
        }

        @Test
        @DisplayName("뽑혔는가")
        void oneGachaTest(){

            Gacha gacha = new Gacha(item,target);
            double f = 0.0012f;

            assertInstanceOf(Boolean.class, gacha);
        }
    }


    @Nested
    public class ReadyForGachaTest {

        @BeforeEach
        @DisplayName("기본 Gacha 세팅")
        void setUp() {

        }

        @Test
        @DisplayName("Target을 만들기 위해 남은 item 수량 찾기")
        void getLeftItemNumTest(){

            String targetName = target.getName();
            HashSet<String> itemname = new HashSet<>(target.getRecipe());

            HashMap<String,Integer> leftItem = 

            //itemname 안에 있는 

            // gacha 객체 생성
            Gacha gacha = new Gacha(item,target);

            // gacha전 남은 item 수량

            
            gacha.



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
