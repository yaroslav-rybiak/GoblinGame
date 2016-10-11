import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    public static String askName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please tell me your name");
        return br.readLine();
    }

    private String name;
    private int level;
    private int health;
    private int strength;

    public void getInfo() {
        System.out.println(String.format("Your name is %s, your level is %d. You have %d health and %d strength.",
                this.name, this.level, this.health, this.strength));
    }

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
