import java.io.IOException;

public class Room {

    public static void emptyRoom() throws IOException {
        System.out.println("The room is empty!");
        Player.askWhatNext();
    }

}
