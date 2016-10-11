import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    public static void die(Player player) {
        System.out.println(String.format("Here lies %s, who had reached level %d before meeting an inglorious death.",
                player.getName(), player.getLevel()));
    }

    public static String askName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please tell me your name");
        return br.readLine();
    }

    private String name;
    private int level;
    private int health;
    private int strength;

    public void getInfo() {
        System.out.println(String.format("Your name is %s, your level is %d. You have %d health and %d strength.",
                this.name, this.level, this.health, this.strength));
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public static void askWhatNext(Player player) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userAction;
        do {
            System.out.println("You see a door, what are you going to do? (open, info or exit)");
            userAction = br.readLine();
        }
        while (!userAction.equals("open") && !userAction.equals("o") &&
               !userAction.equals("exit") && !userAction.equals("e") &&
               !userAction.equals("info") && !userAction.equals("i"));
        switch(userAction) {
            case ("info") :case ("i") : {
                player.getInfo();
                Player.askWhatNext(player);
                break;
            }
            case ("open") : case ("o") : {
                Door.open(player);
                break;
            }
            case ("exit") :case ("e") : {
                Player.die(player);
                System.exit(0);
                break;
            }
        }
    }

    public int getStrength() {
        return this.strength;
    }

    //constructor
    Player (String name)
    {
        this.name = name;
        this.strength = 2;
        this.health = 10;
        this.level = 1;
    }

    void levelUp() {
        this.level++;
        this.strength++;
    }

    void loseHealth() {
        this.health--;
    }
}
