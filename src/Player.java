public class Player {

    private String name;
    private int level;
    private int health;
    private int strength;

    public int getStrength() {
        return this.strength;
    }

    //constructor
    Player (String name)
    {
        this.name = name;
        this.strength = 2;
        this.health = 10;
        this.level = 1;
    }

}
