import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    public static void die() {
        System.out.println("You are dead.");
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

    public static void askWhatNext() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userAction;
        do {
            System.out.println("You see a door, what would you do? (open or exit)");
            userAction = br.readLine();
        }
        while (!userAction.equals("open") && !userAction.equals("exit") &&
                !userAction.equals("o") && !userAction.equals("e"));
        switch(userAction) {
            case ("open") : case ("o") : {
                Door.open();
                break;
            }
            case ("exit") :case ("e") : {
                Player.die();
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

}
