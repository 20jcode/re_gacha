package re_gacha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.Item;
import re_gacha.mainlogic.Target;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

import re_gacha.mainlogic.Gacha;
import re_gacha.mainlogic.GachaController;


public class GachaControllerTest {

    @Nested
    @DisplayName("기본 멤버변수 체크")
    public class LikeUserTest{

        private Item item;
        private Target target;
        

        @BeforeEach
        void setUp(){

            Map<String,Integer> defaultMap = new HashMap<>();

            defaultMap.put("blacktiket",120);
            
            item = new Item(defaultMap);


        }

        @Test
        @DisplayName("item 수량 조회")
        void findItemTest(){

            GachaController gachaController = new GachaController();

            gachaController.setItem(item);

            assertEquals(120, gachaController.getItem("blacktiket"));

        }

        

    }

    @Nested
    @DisplayName("메인 로직")
    public class LogicTest{

        private Item item;
        private Target target;

        @Test
        @DisplayName("실제 사용 예시")
        void realTest(){

            //base data

            Map<String,Integer> defaultMap = new HashMap<>();
            defaultMap.put("blacktiket",180);
            
            target = new Target("happyPowerMode");
            target.setRecipe("happyStone", 4);
            target.setRecipe("happyREV", 1);
            target.setUseItem("blacktiket", -1);

            LinkedList<Integer> expectedAns = new LinkedList<>();

            expectedAns.add(120);
            expectedAns.add(4);
            expectedAns.add(0);

            //gachaController setting

            GachaController gachaController = new GachaController();

            gachaController.setItem(item);
            gachaController.setTarget(target);

            //gachaController testing

            gachaController.doGacha(1000); //가챠 실행, params 모의 실행횟수

            LinkedList<Integer> realAns = gachaController.getAns();
        


        }

        @Test
        @DisplayName("내부 1회 가챠")
        void innerTest(){

            Map<String,Integer> wantItem = new HashMap<>(); //뽑고 싶은 것

            wantItem.put("happyStone",4);
            wantItem.put("happyREV",1);

            Map<String,Double> targetValue = new HashMap<>(); //뽑고 싶은 것의 확률

            targetValue.put("happyStone",0.013300d);
            targetValue.put("happyREV",0.006670d);

            int userItem = 180; // 소비하는 재화

//TODO : target에 천장 규칙 추가해주기

            Map<String,List<Integer>> isSky = new HashMap<>();  

            isSky.put("happyStone",Arrays.asList(50,120,180)); // 해당 숫자만큼 뽑기 진행시 무조건 획득
            isSky.put("happyREV",Arrays.asList(180));

            Map<String,Integer> isUnfixSky = new HashMap<>(); // 뽑기 중간에 아이템이 나올 경우 초기화됨

            isUnfixSky.put("happyStone",80);
            isUnfixSky.put("happyREV",80);

            GachaController gachaController = new GachaController();

            

            LinkedList<Integer> a = gachaController.innerGacha(wantItem,targetValue,userItem,isSky,isUnfixSky);


        }
    }
    
}
