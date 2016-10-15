import java.io.IOException;

class Room {

    private String type;

    //constructor
    private Room ()
    {
        String[] types ={"empty", "treasury", "trap", "fountain", "library", "cellar"};
        this.type = types[Helper.getRandomNumber(0, types.length - 1)];
    }

    static void meetRoom(Player player) throws IOException {
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
            case("library") : {
                Room.libraryRoom(player);
                break;
            }
            case("cellar") : {
                Room.potionRoom(player);
                break;
            }
        }
    }

    private static void potionRoom(Player player) throws IOException {
        System.out.println("You've found someone's wine cellar. You've stolen a healing potion.");
        player.addItemToBackpack("potion");
        player.askWhatNext();
    }

    private static void emptyRoom(Player player) throws IOException {
        System.out.println("You've entered an empty room.");
        player.askWhatNext();
    }

    private static void treasuryRoom(Player player) throws IOException {
        System.out.println("You found a treasury and became a little reacher.");
        player.receiveGold();
        player.askWhatNext();
    }

    private static void fountainRoom(Player player) throws IOException {
        System.out.println("You've found a fountain of health. You feel a little better now.");
        player.gainHealth(5);
        player.askWhatNext();
    }

    private static void libraryRoom(Player player) throws IOException {
        System.out.println("You found a library and gained the experience that you never had in real life.");
        player.levelUp();
    }

    private static void trapRoom(Player player) throws IOException {
        System.out.println("It's a trap! You've lost some health.");
        player.loseHealth(1);
        if (player.getHealth() <= 0) {
            player.die();
        }
        else {
            player.getShortInfo();
            player.askWhatNext();
        }
    }
}