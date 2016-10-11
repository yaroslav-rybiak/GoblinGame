import java.io.IOException;

public class Room {

    private String type;

    private String[] types ={"empty", "treasury", "trap"};

    //constructor
    Room ()
    {
        this.type = types[Helper.getRandomNumber(0, types.length - 1)];
    }

    public static void meetRoom(Player player) throws IOException {
        Room room = new Room();
        switch(room.type) {
            case("empty") : {
                Room.emptyRoom(player);
                break;
            }
            case("treasury") : {
                Room.treasuryRoom(player);
                break;
            }
            case("trap") : {
                Room.trapRoom(player);
                break;
            }
        }
    }

    public static void emptyRoom(Player player) throws IOException {
        System.out.println("You entered an empty room.");
        Player.askWhatNext(player);
    }

    public static void treasuryRoom(Player player) throws IOException {
        System.out.println("You found a treasury and became a little reacher.");
        player.receiveGold();
        Player.askWhatNext(player);
    }

    public static void trapRoom(Player player) throws IOException {
        System.out.println("It's a trap! You've lost some health.");
        player.loseHealth();
        player.getShortInfo();
        Player.askWhatNext(player);
    }
}
