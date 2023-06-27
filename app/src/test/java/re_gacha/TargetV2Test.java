package re_gacha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.LinkedList;
import java.lang.IllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.TargetV2;

public class TargetV2Test {
    
    TargetV2 target;

    @BeforeEach
    @Disabled
    void setUp(){

        target = new TargetV2("happy");

        target.setRecipe("happystone", 4);
        target.setRecipe("happyEVR", 1);
        target.setUseItem("blacktiket", -1);

        //TODO : 무조건적으로 target의 setRecipe와 setUseItem을 할 수 있도록 강요
    }

    @Test
    @DisplayName("레시피 커넥트 테스트")
    void connectTest(){

        assertDoesNotThrow(()->target.recipeConnet("happystone","blacktiket"));
        assertDoesNotThrow(()->target.recipeConnet("happyEVR","blacktiket"));

        assertThrows(IllegalArgumentException.class,()->target.recipeConnet("dfw", "blacktiket"));



        
    }

    @Test
    @DisplayName("기본 메서드 오버라이딩")
    void perTest(){

        

        String consumName = "blacktiket";

        assertDoesNotThrow(()->target.getPer("happystone"));
        assertDoesNotThrow(()->target.getUseItem("happystone"));


    }

}
