import java.io.IOException;

public class Door {
    public void open(Player player) throws IOException {
        int choice = 1;// Helper.getRandomNumber(0, 1);
        switch (choice) {
            case(0) : {
                Room.meetRoom(player);
                player.askWhatNext();
                break;
            }
            case(1) : {
                Monster.meetMonster(player);
                player.askWhatNext();
                break;
            }
        }
    }
}
