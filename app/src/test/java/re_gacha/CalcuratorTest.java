package re_gacha;

import re_gacha.Calcurator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class CalcuratorTest {
    
    @Test
    @DisplayName("확률이 m일때 몇번만에 뽑는지 시뮬레이션")
    public void testCal() {
        Calcurator calcurator = new Calcurator();
        double m = 0.01;

        int result = calcurator.gachaOnceNumber(m);

        assertTrue(result>10, "test123");
    }
}
