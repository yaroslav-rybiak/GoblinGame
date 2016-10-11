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

}
