import java.io.IOException;

public class Room {

    public static void emptyRoom(Player player) throws IOException {
        System.out.println("The room is empty.");
        Player.askWhatNext(player);
    }

}
