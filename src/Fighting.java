public class Fighting {

    public void start(Player player, Monster monster) {
        System.out.println(String.format("The fight between %s and %s %s has started!",
                player.getName(), monster.getType(), monster.getName()));
        do {
            int playerDamage = damage(player);
            System.out.println(String.format("You hit a %s and made %d damage.",
                    monster.getName(), playerDamage));
            monster.loseHealth(playerDamage);
            if (monster.getHealth() > 0) {
                int monsterDamage = damage(monster);
                System.out.println(String.format("%s hit you and made %d damage.",
                        Helper.makeFirstLetterCapital(monster.getName()), monsterDamage));
                player.loseHealth(monsterDamage);
            }
            System.out.println(String.format("You have %s health, %s has %s health.",
                    player.getHealth(), monster.getName(), monster.getHealth()));

        }
        while (monster.getHealth() > 0 && player.getHealth() > 0);
        if (monster.getHealth() <= 0 && player.getHealth() > 0) {
            System.out.println(String.format("You killed the %s.", monster.getName()));
        }
        else if (monster.getHealth() <= 0 && player.getHealth() <= 0) {
            System.out.println("Both died.");
        }
        else if (monster.getHealth() >= 0 && player.getHealth() <= 0) {
            System.out.println(String.format("%s killed you.", Helper.makeFirstLetterCapital(monster.getName())));
            Player.die(player);
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
