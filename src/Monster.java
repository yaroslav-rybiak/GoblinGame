import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Monster {

    private int strength;
    private int health;
    private String type;
    private String name;

    //constructor
    private Monster (Player player)
    {
        String[] names ={"goblin", "demon", "mandrake", "dragon", "troll", "morlock", "golem", "kraken", "harpy"};
        String[] types ={"water", "fire", "metal", "ghost", "grass", "thermal", "sea", "lake", "greasy", "hairy"};
        this.strength = Helper.getRandomNumber(player.getStrength()-1, player.getStrength()+1);
        this.type = types[Helper.getRandomNumber(0, types.length - 1)];
        this.name = names[Helper.getRandomNumber(0, names.length - 1)];
        int[] healths ={(player.getStrength()-2)*5, (player.getStrength()-1)*4, (player.getStrength())*3};
        this.health = healths[Helper.getRandomNumber(0, healths.length - 1)];

    }

    String getType() {
        return this.type;
    }

    String getName() {
        return this.name;
    }

    int getStrength() {
        return this.strength;
    }
    int getHealth() {
        return this.health;
    }
    private void setHealth(int health) {
        this.health = health;
    }

    static void meetMonster(Player player) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userAction;
        Monster monster = new Monster(player);
        System.out.println(String.format("You've met a %s %s, it has %d health and %d strength.",
                monster.getType(), monster.getName(), monster.getHealth(), monster.getStrength()));
        player.getShortInfo();
        do {
            System.out.println("What are you going to you do? (fight or run)");
            userAction = br.readLine().toLowerCase();
        }
        while (!userAction.equals("fight") && !userAction.equals("f") &&
                !userAction.equals("run") && !userAction.equals("r"));

        switch(userAction) {
            case ("fight") : case ("f") : {
                Fighting fighting = new Fighting();
                fighting.start(player, monster);
                break;
            }
            case ("run") : case ("r") : {
                System.out.println("Let's roll a 24 sided dice.");
                int diceResult = Helper.getRandomNumber(1, 24);
                System.out.println(String.format("Your result is %d.", diceResult));
                if (diceResult <= 12) {
                    System.out.println("You escaped but lost some health while running away like a chicken.");
                    player.loseHealth(1);
                    if (player.getHealth() > 0) {
                        player.getShortInfo();
                    }
                    else {
                        player.die();
                    }
                }
                else {
                    System.out.println("You've successfully ran from the monster.");
                }
                break;
            }
        }
    }

    void loseHealth(int hit) {
        this.health -= hit;
    }

    void die() {
        this.setHealth(0);
    }
}