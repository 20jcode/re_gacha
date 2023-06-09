package re_gacha;
import java.util.Random;


public class Calcurator {
    public int gachaOnceNumber(double num) {
        Random random = new Random();

        boolean isSucess = false;

        int counter = 0;

        while(!isSucess) {
            counter++;
            double ans = random.nextDouble();

            if (ans> 1-num) {
                isSucess = true;
            }
        }

        return counter;
    }
}
