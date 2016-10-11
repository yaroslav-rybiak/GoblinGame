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

    public static void meetMonster(Player player) {
        Monster monster = new Monster(player);
        System.out.println(String.format("You've met a %s %s, he has %d strength.",
                monster.getType(), monster.getName(), monster.getStrength()));
    }

}
