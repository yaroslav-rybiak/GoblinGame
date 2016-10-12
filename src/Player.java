import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Player {

    void die() {
        System.out.println(String.format("Here lies %s, who had reached level %d before meeting an inglorious death.",
                this.getName(), this.getLevel()));
        if (this.getGold() == 0) {
            System.out.println("You haven't managed to collect any gold.");
        }
        else {
            System.out.println(String.format("You've managed to collect %d gold, but you can't take money to the grave.",
                    this.getGold()));
        }
        System.exit(0);
    }

    static String askName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please tell me your name.");
        return br.readLine();
    }

    private String name;
    private int level;
    private int health;
    private int strength;
    private int gold;

    private void getFullInfo() {
        System.out.println(String.format("Your name is %s, your level is %d.\nYou have %d health and %d strength.",
                this.getName(), this.getLevel(), this.getHealth(), this.getStrength()));
        if (this.getGold() == 0) {
            System.out.println("There is no gold in your pockets.");
        }
        else {
            System.out.println(String.format("There are %d gold in your pockets.", this.getGold()));
        }
    }

    void getShortInfo() {
        System.out.println(String.format("You have %d health and %d strength.",
                this.health, this.strength));
    }

    String getName() {
        return this.name;
    }

    private int getLevel() {
        return this.level;
    }

    int getHealth() {
        return this.health;
    }

    int getStrength() {
        return this.strength;
    }

    private int getGold() {
        return this.gold;
    }

    void askWhatNext() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userAction;
        Door door = new Door();
        do {
            System.out.println("You see a door, what are you going to do? (open, info or suicide)");
            userAction = br.readLine();
        }
        while (!userAction.equals("open") && !userAction.equals("o") &&
                !userAction.equals("suicide") && !userAction.equals("s") &&
                !userAction.equals("info") && !userAction.equals("i"));
        switch(userAction) {
            case ("info") :case ("i") : {
                this.getFullInfo();
                this.askWhatNext();
                break;
            }
            case ("open") : case ("o") : {
                door.open(this);
                break;
            }
            case ("suicide") :case ("s") : {
                this.die();
                System.exit(0);
                break;
            }
        }
    }

    //constructor
    Player (String name)
    {
        this.name = name;
        this.strength = 3;
        this.health = 10;
        this.level = 1;
        this.gold = 0;
    }

    void levelUp() {
        this.level++;
        this.strength++;
        this.health++;
        System.out.println("You feel much stronger now.");
    }

    void loseHealth(int hit) {
        this.health -= hit;
    }

    void gainHealth(int heal) {
        this.health += heal;
    }

    void receiveGold() {
        int[] amounts ={10, 20, 30, 40, 50};
        int amount =  amounts[Helper.getRandomNumber(0, amounts.length - 1)];
        this. gold += amount;
        System.out.println(String.format("You've got %d gold.", amount));
    }
}