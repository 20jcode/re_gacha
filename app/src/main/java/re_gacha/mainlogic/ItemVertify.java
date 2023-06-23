package re_gacha.mainlogic;

import java.lang.IllegalArgumentException;

public class ItemVertify {
    
    static void subError(int value,int param) throws IllegalArgumentException {
        if (value - param < 0){
            throw new IllegalArgumentException("계산 결과 음수입니다");
        }
    }

    static void sumError(int value,int param) throws IllegalArgumentException {
        if (Integer.MAX_VALUE-value < param){
            throw new IllegalArgumentException("계산 결과가 int 의 범위를 벗어납니다");
        }
    }

    static void negativeError(int value) throws IllegalArgumentException {
        if (value < 0){
            throw new IllegalArgumentException("음수가 될 수 없습니다");
        }
    }
}
