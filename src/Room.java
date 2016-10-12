import java.io.IOException;

public class Room {

    private String type;

    private String[] types ={"empty", "treasury", "trap", "fountain"};

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
            case("fountain") : {
                Room.fountainRoom(player);
                break;
            }
        }
    }

    public static void emptyRoom(Player player) throws IOException {
        System.out.println("You entered an empty room.");
        player.askWhatNext();
    }

    public static void treasuryRoom(Player player) throws IOException {
        System.out.println("You found a treasury and became a little reacher.");
        player.receiveGold();
        player.askWhatNext();
    }

    public static void fountainRoom(Player player) throws IOException {
        System.out.println("You found a fountain of health. You feel better now");
        player.gainHealth(5);
        player.askWhatNext();
    }

    public static void trapRoom(Player player) throws IOException {
        System.out.println("It's a trap! You've lost some health.");
        player.loseHealth(1);
        //add death check
        if (player.getHealth() < 0) {
            player.die();
        }
        else {
            player.getShortInfo();
            player.askWhatNext();
        }
    }
}
