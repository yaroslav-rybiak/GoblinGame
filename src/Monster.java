public class Monster {

    private int strength;

    //constructor
    Monster (Player player)
    {
        this.strength = Helper.getRandomNumber(player.getStrength()-1, player.getStrength()+1);
    }

}
