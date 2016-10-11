import java.io.IOException;

public class Door {

    public static void open() throws IOException {
        int choice = Helper.getRandomNumber(0, 1);
        switch (choice) {
            case(0) : {
                Room.emptyRoom();
                Player.askWhatNext();
                break;
            }
            case(1) : {
                Monster.meetMonster();
                Player.askWhatNext();
                break;
            }
        }
    }
}
