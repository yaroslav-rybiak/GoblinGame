import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

class Player {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String getBackpack() {
        return backpack.get(0);
    }

    private List<String> backpack = new ArrayList<>();

    private void checkBackpack() throws IOException {
        String userAction;
        if (this.backpack.get(0).equals("nothing")) {
            System.out.println("Your backpack is empty.");
        }
        else {
            System.out.print("There is a ");
            System.out.print(this.backpack.get(0));
            System.out.print(" in your backpack. ");
            System.out.print("What are you going to do? ");
            do {
                System.out.println("(drink or cancel)");
                userAction = br.readLine();
            }
            while (!userAction.equals("drink") && !userAction.equals("d") &&
                    !userAction.equals("cancel") && !userAction.equals("c"));

            switch (userAction) {
                case ("drink"):
                case ("d"): {
                    this.backpack.remove(0);
                    this.backpack.add("nothing");
                    this.gainHealth(10);
                    System.out.println("You feel much better now.");
                    this.askWhatNext();
                    break;
                }
                case ("cancel"):
                case ("c"): {
                    this.askWhatNext();
                    break;
                }
            }
        }
    }

    void addItemToBackpack(String item) {
        this.backpack.remove(0);
        this.backpack.add(item);
    }

    void die() {
        Helper.printLine();
        System.out.format("Here lies %s, who had reached level %d before meeting an inglorious death.\n",
                this.getName(), this.getLevel());
        Helper.printLine();
        if (this.getDoors() != 1) {
            System.out.format("You went through %d doors.\n", this.getDoors());
        }
        else {
            System.out.println("You went through 1 door.");
        }
        if (this.getGold() == 0) {
            System.out.println("You haven't managed to collect any gold.");
        }
        else {
            System.out.format("You've managed to collect %d gold, but you can't take money to the grave.\n",
                    this.getGold());
        }
        System.exit(0);
    }

    static String askName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;

        System.out.println("You found yourself in a dungeon. You can't remember how you got here.");
        System.out.print("You can hardly remember your own name. ");
        do {
            System.out.println("What's your name?");
            name = br.readLine();
        }
        while (name.equals(""));
        return name;
    }

    void startGame() throws IOException {
        System.out.format("You think that your name is probably %s.\n", this.getName());
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
        System.out.format("Your name is %s, your level is %d. You have %d health and %d strength.\n",
                this.getName(), this.getLevel(), this.getHealth(), this.getStrength());
        if (this.getGold() == 0) {
            System.out.println("There is no gold in your pockets.");
        }
        else {
            System.out.format("There are %d gold in your pockets.\n", this.getGold());
        }
    }

    void getShortInfo() {
        System.out.format("You have %d health and %d strength.\n",
                this.health, this.strength);
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
        String userAction;
        Door door = new Door();

        System.out.print("You see the next door, what are you going to do? ");
        do {
            System.out.println("(open, info, backpack or quit)");
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
                this.checkBackpack();
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
        this.backpack.add("nothing");
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
        System.out.format("You've got %d gold.\n", amount);
    }
}