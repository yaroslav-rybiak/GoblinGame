import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monster {

    private int strength;
    private String type;
    private String name;

    private String[] names ={"goblin", "demon", "mandrake", "dragon", "troll", "morlock", "golem", "kraken", "harpy"};
    private String[] types ={"water", "fire", "metal", "ghost", "grass", "thermal", "sea", "lake", "greasy", "hairy"};

    //constructor
    Monster (Player player)
    {
        this.strength = Helper.getRandomNumber(player.getStrength()-1, player.getStrength()+1);
        this.type = types[Helper.getRandomNumber(0, types.length - 1)];
        this.name = names[Helper.getRandomNumber(0, names.length - 1)];
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public static void meetMonster(Player player) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userAction;
        Monster monster = new Monster(player);
        System.out.println(String.format("You've met a %s %s, he has %d strength.",
                monster.getType(), monster.getName(), monster.getStrength()));
        player.getShortInfo();
        do {
            System.out.println("What are you going to you do? (fight or run)");
            userAction = br.readLine().toLowerCase();
        }
        while (!userAction.equals("fight") && !userAction.equals("f") &&
                !userAction.equals("run") && !userAction.equals("r"));

        switch(userAction) {
            case ("fight") : case ("f") : {
                if (player.getStrength() >= monster.getStrength()) {
                    System.out.println("You won.");
                    player.levelUp();
                }
                else {
                    System.out.println("You fought the monster, but he was stronger. You've lost some health.\n");
                    player.loseHealth();
                    player.getShortInfo();
                }
                break;
            }
            case ("run") : case ("r") : {
                System.out.println("Let's roll a 24 sided dice.");
                int diceResult = Helper.getRandomNumber(1, 24);
                System.out.println(String.format("Your result is %d.", diceResult));
                if (diceResult <= 12) {
                    System.out.println("You tried to escape, but failed and lost some health.");
                    player.loseHealth();
                    player.getShortInfo();
                }
                else {
                    System.out.println("You've successfully ran from monster.");
                }
                break;
            }
        }
    }
}
