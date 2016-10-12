import java.util.Random;

public class Helper {

    static int getRandomNumber(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    static String makeFirstLetterCapital (String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

}
