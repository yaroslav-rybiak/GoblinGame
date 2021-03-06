import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Fighting {

    private boolean run = false;

    void start(Player player, Monster monster) throws IOException {
        System.out.format("The fight between %s and %s %s has started!\n",
                player.getName(), monster.getType(), monster.getName());
        while (monster.getHealth() > 0 && player.getHealth() > 0 && !run) {
            int playerDamage = damage(player);
            System.out.format("You hit the %s and made %d damage.\n",
                    monster.getName(), playerDamage);
            monster.loseHealth(playerDamage);
            if (monster.getHealth() > 0) {
                int monsterDamage = damage(monster);
                System.out.format("The %s hit you and made %d damage.\n",
                        monster.getName(), monsterDamage);
                player.loseHealth(monsterDamage);
                if (player.getHealth() <= 0) {
                    player.die();
                }
            }
            else {
                break;
            }
            System.out.format("You have %s health, the %s has %s health.\n",
                    player.getHealth(), monster.getName(), monster.getHealth());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String userAction;
            do {
                System.out.println("What are you going to do next? (fight or run)");
                userAction = br.readLine().toLowerCase();
            }
            while (!userAction.equals("fight") && !userAction.equals("f") &&
                    !userAction.equals("run") && !userAction.equals("r"));
            switch(userAction) {
                case ("run") : case ("r") : {
                    run = true;
                    System.out.println("Let's roll a 24 sided dice.");
                    int diceResult = Helper.getRandomNumber(1, 24);
                    System.out.format("Your result is %d.\n", diceResult);
                    if (diceResult <= 12) {
                        System.out.println("You escaped but lost some health while running away like a chicken.");
                        player.loseHealth(2);
                        if (player.getHealth() <= 0) {
                            player.die();
                        }

                    }
                    else {
                        monster.die();
                    }
                    break;
                }
            }
        }

        if (run) {
            System.out.println("You ran away.");
        }

        else if (monster.getHealth() <= 0 && player.getHealth() > 0) {
            System.out.format("You've killed the %s.\n", monster.getName());
            player.levelUp();
        }

        else if (monster.getHealth() <= 0 && player.getHealth() <= 0) {
            System.out.println("Both died.");
        }
        else if (monster.getHealth() > 0 && player.getHealth() <= 0) {
            System.out.format("The %s killed you.\n", monster.getName());
            player.die();
        }
        player.getShortInfo();
    }

    private int damage(Player player) {
        int[] damages ={(player.getStrength()-2), (player.getStrength()-1), (player.getStrength())};
        return damages[Helper.getRandomNumber(0, damages.length - 1)];
    }

    private int damage(Monster monster) {
        int[] damages ={(monster.getStrength()-2), (monster.getStrength()-1), (monster.getStrength())};
        return damages[Helper.getRandomNumber(0, damages.length - 1)];
    }
}