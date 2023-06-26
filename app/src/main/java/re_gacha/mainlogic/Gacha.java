package re_gacha.mainlogic;

import java.lang.Math;
import java.util.Random;
import java.lang.IllegalArgumentException;

/**
 * Use GachaV2Test.class
 * TODO - seperate Gacha and GachaController
 * TODO - Use BigDecimal
 */
public class Gacha {

   
    
    public Gacha(){}

    public static Boolean oneGacha(double f){

        double randNum = Math.random(); // 랜덤값이 f(뽑힐 확률)보다 높으면 뽑힘.

        if (f>randNum){
            return true;
        } else {
            return false;
        }
        
    }

    public static Boolean oneGacha(Random random, double f){

        double randNum = random.nextDouble();

        if (f>randNum){
            return true;
        } else {
            return false;
        }
    }

    public static double multiGacha(double... args){

        Random random = new Random();

        return multiGacha(random, args);


    }

    public static double multiGacha(Random random, double...args){

        return randLogic(random.nextDouble(),args);
    }

    // TODO : 접근자 변경 필요
    public static double randLogic(double randnum, double...args) throws IllegalArgumentException{// double -> int , 오차보정 

        // 오류검사
        double sum = 0;
        for(double arg : args){

            if(arg <0){
                throw new IllegalArgumentException("음수를 넣을 수 없습니다");
            }
            sum += arg;
        }

        if (sum>=1){
            throw new IllegalArgumentException("확률은 1을 넘을 수 없습니다");
        }

        // 계산부분
        int underN = 1000000; // 10^6
        int rand = (int)(randnum*1000000); // (int) 연산 먼저 되므로 괄호가 중요함!

        for(double arg : args){
            int toInt = (int)(arg*1000000);

            if ((underN-toInt <= rand) && (rand < underN)){
                return arg;
            } else {
                underN -= toInt;
            }
        }

        return 0;

    }

    
}
