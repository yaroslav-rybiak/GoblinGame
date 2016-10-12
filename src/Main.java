import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Player player = new Player(Player.askName());
        player.greetings();
        player.askWhatNext();
    }

}