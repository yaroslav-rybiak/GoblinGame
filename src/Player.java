import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    public static void die(Player player) {
        System.out.println(String.format("Here lies %s, who had reached level %d before meeting an inglorious death.",
                player.getName(), player.getLevel()));
        if (player.getGold() == 0) {
            System.out.println("You haven't managed to collect any gold.");
        }
        else {
            System.out.println(String.format("You've managed to collect %d gold, but you can't take money to the grave.",
                    player.getGold()));
        }
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
    private int gold;

    public void getFullInfo() {
        System.out.println(String.format("Your name is %s, your level is %d.\nYou have %d health and %d strength.",
                this.getName(), this.getLevel(), this.getHealth(), this.getStrength()));
        if (this.getGold() == 0) {
            System.out.println("There are no gold in your pockets.");
        }
        else {
            System.out.println(String.format("There are %d gold in your pockets.", this.getGold()));
        }
    }

    public void getShortInfo() {
        System.out.println(String.format("You have %d health and %d strength.",
                this.health, this.strength));
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getGold() {
        return this.gold;
    }

    public static void askWhatNext(Player player) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userAction;
        //player.getFullInfo();
        do {
            System.out.println("You see a door, what are you going to do? (open, info or suicide)");
            userAction = br.readLine();
        }
        while (!userAction.equals("open") && !userAction.equals("o") &&
                !userAction.equals("suicide") && !userAction.equals("s") &&
                !userAction.equals("info") && !userAction.equals("i"));
        switch(userAction) {
            case ("info") :case ("i") : {
                player.getFullInfo();
                Player.askWhatNext(player);
                break;
            }
            case ("open") : case ("o") : {
                Door.open(player);
                break;
            }
            case ("suicide") :case ("s") : {
                Player.die(player);
                System.exit(0);
                break;
            }
        }
    }

    //constructor
    Player (String name)
    {
        this.name = name;
        this.strength = 2;
        this.health = 10;
        this.level = 1;
        this.gold = 0;
    }

    void levelUp() {
        this.level++;
        this.strength++;
    }

    void loseHealth() {
        this.health--;
    }

    void receiveGold() {
        int[] amounts ={10, 20, 30, 40, 50};
        int amount =  amounts[Helper.getRandomNumber(0, amounts.length - 1)];
        this. gold += amount;
        System.out.println(String.format("You've got %d gold.", amount));
    }
}
