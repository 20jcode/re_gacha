package re_gacha;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

// re_gacha
import re_gacha.mainlogic.Gacha;

// utils
import java.util.Random;

public class GachaV2Test {
    
    @Nested
    @DisplayName("가챠 실행")
    public class GachaOneTimeTest{

        @Test
        @DisplayName("단일 가챠 실행 가능")
        void gachaOneTest(){

            double testnum = 0.01d;

            assertInstanceOf(Boolean.class, Gacha.oneGacha(testnum));
        }
        @Test
        @DisplayName("오버로딩")
        void gachaOverLoadingTest(){
            int seed = 10;
            Random random = new Random(seed);

            double testnum = 0.01d;
            
            assertInstanceOf(Boolean.class,Gacha.oneGacha(random,testnum));

        }

        @Test
        @DisplayName("경계값 테스트")
        @RepeatedTest(100)
        void gachaBoundaryTest(){

            double one = 1d;
            double zero = 0d;
            double closeOne = 0.9999999d;
            double closeZero = 0.0000001d;

            int seed = 10;
            Random random = new Random(seed);

            // seed값 기준 100번 이내에 아래의 테스트는 항상 통과함.
            assertTrue(Gacha.oneGacha(random,one));
            assertFalse(Gacha.oneGacha(random,zero));
            assertTrue(Gacha.oneGacha(random,closeOne));
            assertFalse(Gacha.oneGacha(random,closeZero));
        }
    }

    @Nested
    @DisplayName("복수 가챠 로직 실행")
    public class GachaMultiLogicTest{

        @Test
        @DisplayName("복수 가챠 로직 점검")
        void multiLogicTest(){

            double item1 = 0.12d;
            double item2 = 0.06d;
            double item3 = 0.3d;
            // 1>item1>=0.88 , 0.88>item2>=0.82, 0.82>item3>=0.52, (int)0
            
            double randnum1 = 0.354d;
            double randnum2 = 0.88d;
            double randnum3 = 0.82d;
            double randnum4 = 0.12d;
            double randnum5 = 0.52d;
            double randnum6 = 0;
            double randnum7 = 0.99999d;

            assertEquals(0,Gacha.randLogic(randnum1,item1,item2,item3));
            assertEquals(item1,Gacha.randLogic(randnum2,item1,item2,item3));
            assertEquals(item2,Gacha.randLogic(randnum3,item1,item2,item3));
            assertEquals(0,Gacha.randLogic(randnum4,item1,item2,item3));
            assertEquals(item3,Gacha.randLogic(randnum5,item1,item2,item3));
            assertEquals(0,Gacha.randLogic(randnum6,item1,item2,item3));
            assertEquals(item1,Gacha.randLogic(randnum7,item1,item2,item3));
            
        }

        @Test
        @DisplayName("1이 넘는 확률 오류")
        void multiLogicOverOneErrTest(){

            double err1 = 0.4d;
            double err2 = 0.5d;
            double err3 = 0.3d;

            double randnum = 0.123d;

            assertThrowsExactly(IllegalArgumentException.class, ()->Gacha.randLogic(randnum,err1,err2,err3,err3),
            "확률은 1을 넘을 수 없습니다");
            
        }

        @Test
        @DisplayName("1을 넣을 경우")
        void inputOneErrTest(){

            double err1 = 1.0d;
            double err2 = 0.0d;
            double err3 = 0.0d;

            double randnum = 0.45d;

            assertThrowsExactly(IllegalArgumentException.class, ()->Gacha.randLogic(randnum, err1,err2,err3));
        }

        @Test
        @DisplayName("음수가 있을 경우")
        void inputNegativeErrTest(){

            double err1 = -0.12d;
            double err2 = -0.23d;

            double randnum = 0.23d;

            assertThrowsExactly(IllegalArgumentException.class, ()->Gacha.randLogic(randnum,err1,err2));


        }

    }

    @Nested
    @DisplayName("복수가챠 실행 테스트")
    public class multiGachaTest{

        @Test
        @DisplayName("복수 가챠 가능 여부 확인")
        void canMultitest(){

            // 한 뽑기에서 a,b,c 상품이 나올 수 있을 때, 하나를 선택
            double item1 = 0.12d;
            double item2 = 0.06d;
            double item3 = 0.3d;

            int seed=10;
            Random random = new Random(seed);

            // 정상작동 체크
            assertNotNull(Gacha.multiGacha(item1,item2,item3));
            assertNotNull(Gacha.multiGacha(item1,item2));
            assertNotNull(Gacha.multiGacha(random,item1,item2));


        }

        
    }
    


}
