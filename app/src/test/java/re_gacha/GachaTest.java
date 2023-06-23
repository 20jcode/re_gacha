package re_gacha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.Gacha;
import re_gacha.mainlogic.Target;

public class GachaTest {
    
    Target t = new Target("happy");
        
    t.setRecipe("stone",4);
    t.setRecipe("happygack",1);

    @Test
    void test1(){
        t.getName();
    }
    
    @Nested
    public class GachalogicTest {

        

        @BeforeEach
        @DisplayName("기본 Gacha 세팅")
        void setUp(){

        }
    }
}
