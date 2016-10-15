import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

class Player {
    private List<String> backpack = new ArrayList<>();

    private void getBackpack() {

        if (this.backpack.isEmpty()) {
            System.out.println("You have nothing in your backpack.");
        }
        else {
            System.out.println("There is something in your backpack.");
        }
    }

    public void addItemToBackpack(String item) {
        this.backpack.add(item);
    }

    void die() {
        System.out.println(String.format("Here lies %s, who had reached level %d before meeting an inglorious death.",
                this.getName(), this.getLevel()));
        if (this.getDoors() != 1) {
            System.out.println(String.format("You went through %d doors.", this.getDoors()));
        }
        else {
            System.out.println("You went through 1 door.");
        }
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
        System.out.println("You found yourself in a dungeon. You can't remember how you got here.");
        System.out.println("You can hardly remember your own name. What's your name?");
        return br.readLine();
    }

    void greetings() throws IOException {
        System.out.println(String.format("You think that your name is probably %s.", this.getName()));
        System.out.println("You came here through the door that disappeared behind your back.");
        System.out.println("Now you see the only door that leads to the lower level of the dungeon.");
        System.out.println("What's there? You don't know. Do you have a chance to escape? Try to find it out.");
        this.askWhatNext();
    }

    private int doors;
    private String name;
    private int level;
    private int health;
    private int strength;
    private int gold;

    void incrementDoor() {
        this.doors++;
    }

    private int getDoors() {
        return this.doors;
    }

    private void getFullInfo() {
        System.out.println(String.format("Your name is %s, your level is %d. You have %d health and %d strength.",
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
            System.out.println("You see the next door, what are you going to do? (open, info, backpack or quit)");
            userAction = br.readLine();
        }
        while (!userAction.equals("open") && !userAction.equals("o") &&
                !userAction.equals("info") && !userAction.equals("i") &&
                !userAction.equals("backpack") && !userAction.equals("b") &&
                !userAction.equals("quit") && !userAction.equals("q"));

        switch(userAction) {
            case ("open") : case ("o") : {
                door.open(this);
                break;
            }
            case ("info") :case ("i") : {
                this.getFullInfo();
                this.askWhatNext();
                break;
            }
            case ("backpack") :case ("b") : {
                this.getBackpack();
                this.askWhatNext();
                break;
            }
            case ("quit") :case ("q") : {
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