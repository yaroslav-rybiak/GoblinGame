import java.io.IOException;

class Door {
    void open(Player player) throws IOException {
        player.incrementDoor();
        int choice = Helper.getRandomNumber(0, 1);
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