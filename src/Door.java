import java.io.IOException;

public class Door {

    public static void open(Player player) throws IOException {
        int choice = Helper.getRandomNumber(0, 1);
        switch (choice) {
            case(0) : {
                Room.meetRoom(player);
                Player.askWhatNext(player);
                break;
            }
            case(1) : {
                Monster.meetMonster(player);
                Player.askWhatNext(player);
                break;
            }
        }
    }
}
