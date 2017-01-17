import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class Game {
    File[] rawFiles = new File("data/monsters").listFiles();

    //Entrypoint
    public static void main(String[] args) {
        new Game();
    }

    Scanner input;

    String[] monsterNames = {"Slime","Goblin","Steve","Annoying person"};
    String currentMonster;

    int mHealth = 0;
    int pHealth = 20;
    int xp = 0;
    int pLevel = 1;

    //Start here
    public Game() {
        input = new Scanner(System.in);

        while (pHealth > 0) continue; {
        System.out.println("\nYou awaken in a desolate field, with nothing but grass and a handful of trees scattered around you.\n");
        System.out.println("---------------------------------\n");
        System.out.println("What do you do?");

        char action = input.nextLine().toLowerCase().charAt(0);

        switch (action) {

            case 'l':
                System.out.println("You look around. Upon further investigation you notice what looks like a small house to the east.");
                break;
            case 'r':
                System.out.println("You have no supplies other than simple clothes and a pouch with a loaf of bread.\n");
                break;
            case 'h':
                System.out.println("Your options are \n[L]ook around\n[R]est\n[H]elp");
            default:
                System.out.println("You have no supplies other than simple clothes and a pouch with a loaf of bread.\n");
                break;
            
}
        if (mHealth <= 0) {
            ///xp += mHealth/=2;
            mHealth = 20;
            currentMonster = monsterNames[(int)Math.floor(Math.random()*monsterNames.length)];
            ///System.out.println("You have gained " + xp + " XP.");
            System.out.println(currentMonster + " approaches!");


        System.out.println("What's your plan, buddy?\n[A]ttack\n[H]eal\n[N]egotiate\n[R]un");

        switch (action) {

            case 'a':
                System.out.println("You attack the " + currentMonster + "!!");
                mHealth -= 20;
                System.out.println(currentMonster + " is now at " + mHealth + " health. Good job, for a newbie.");
                break;
            case 'h':
                pHealth += 3;
                System.out.println("You take a swig-skey of whiskey. All your problems fly out the window!\nYou are now at " + pHealth + " health.");
                break;
            case 'q':
                System.exit(0);
            }
        
    }
}
}
}