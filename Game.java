import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class Game {
    File[] rawFiles = new File("data/monsters").listFiles();

    //Entrypoint
    public static void main(String[] args) {
        new Game();
    }

    public static void slowPrintln(String text) {
        slowPrintln(text, 40);
    }

    public static void slowPrintln(String text, int ms) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(ms);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
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

        ///while (pHealth > 0) {
        slowPrintln("\nYou awaken in a desolate field, with nothing but grass and a handful of trees scattered around you.\n");
        System.out.println("---------------------------------\n");
        slowPrintln("What do?");

        System.out.print("> ");
        String thing = input.nextLine();
        char action = thing.toLowerCase().charAt(0);

        switch (action) {

            case 'l':
                slowPrintln("You look around. Upon further investigation you notice what looks like a small house to the east.\nWhat next?");
                System.out.print("> ");
                thing = input.nextLine();
                action = thing.toLowerCase().charAt(0);
                switch (action) {
                    case 'g':
                        slowPrintln("Upon arriving at the structure, you see that it is a small house. You stop before reaching what looks like the main door.");
                        break;
                    case 'c':
                        slowPrintln("Upon arriving at the structure, you see that it is a small house. You stop before reaching what looks like the main door.");
                    case 'q':
                        System.exit(0);
                    default:
                        slowPrintln("You " + thing + ".");
                }
                break;
            case 'h':
                slowPrintln("Your options are \n[L]ook around\n[R]est\n[H]elp");
                break;
            case 'q':
                System.exit(0);
            default:
                slowPrintln("You have no supplies other than simple clothes and a pouch with a loaf of bread, but you do manage to " + thing + ".\n");
                break;
            
        }
        if (mHealth <= 0) {
            mHealth = 20;
            currentMonster = monsterNames[(int)Math.floor(Math.random()*monsterNames.length)];
            slowPrintln(currentMonster + " approaches!", 20);


       slowPrintln("What's your plan, buddy?\n[A]ttack\n[H]eal\n[N]egotiate\n[R]un");
        System.out.print("> ");
        thing = input.nextLine();
        action = thing.toLowerCase().charAt(0);

        switch (action) {

            case 'a':
                slowPrintln("You attack the " + currentMonster + "!!");
                mHealth -= 20;
                slowPrintln(currentMonster + " is now at " + mHealth + " health. Good job, for a newbie.");
                break;
            case 'h':
                pHealth += 3;
                slowPrintln("You take a swig-skey of whiskey. All your problems fly out the window!\nYou are now at " + pHealth + " health.");
                break;
            case 'q':
                System.exit(0);
            default:
                System.out.println("You " + thing + ".");
            }
        
    }
}
}