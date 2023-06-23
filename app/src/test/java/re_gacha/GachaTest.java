package re_gacha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import re_gacha.mainlogic.Gacha;
import re_gacha.mainlogic.Target;

public class GachaTest {

    Target target = new Target("happy");

    @BeforeEach
    @Test
    void Setup() {
        target.setRecipe("realstone", 4);
        target.setRecipe("gack", 1);
    }

    @Nested
    public class GachalogicTest {

        @BeforeEach
        @DisplayName("기본 Gacha 세팅")
        void setUp() {

        }
    }
}
