package UI;

import Data.Board;
import Data.Player;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author - Juan Ochoa - Diego Ruiz
 */
public class MonopolyTest {

    /**
     * @param args the command line arguments
     */
    private static Scanner reader = new Scanner(System.in);
    private static Scanner reader2 = new Scanner(System.in);
    private static Player p1 = new Player(null, false, 200,0,0);
    private static Player p2 = new Player(null, false, 200,0,0);
    private static Player p3 = new Player(null, false, 200,0,0);
    private static Player p4 = new Player(null, false, 200,0,0);

    public static void main(String[] args) {
        MonopolyConsole console = new MonopolyConsole();
        console.welcome();
        switch (console.getOption()) {
            case 1:
                System.out.println("Select number of players (1 to 4)");
                int b = reader.nextInt();
                if (b >= 1) {
                    System.out.println("Write username for player 1");
                    String name = reader2.nextLine();
                    p1 = new Player(name, true, 2205,0,0);
                    if (b >= 2) {
                        System.out.println("Write username for player 2");
                        String name2 = reader2.nextLine();
                        p2 = new Player(name2, false, 2205,0,0);
                        if (b >= 3) {
                            System.out.println("Write username for player 3");
                            String name3 = reader2.nextLine();
                            p3 = new Player(name3, false, 2205, 0,0);
                            if (b == 4) {
                                System.out.println("Write username for player 4");
                                String name4 = reader2.nextLine();
                                p4 = new Player(name4, false, 2205,0,0);
                            }
                        }
                    }
                }
                System.out.println("List of players:");
                System.out.println(p1.getUsername());
                if (p2.getUsername() != null) {
                    System.out.println(p2.getUsername());
                }
                if (p3.getUsername() != null) {
                    System.out.println(p3.getUsername());
                }
                if (p4.getUsername() != null) {
                    System.out.println(p4.getUsername());
                }
                Board gb = new Board();
                Random dice = new Random();
                System.out.println(gb.printBoard(p1.getUsername(), 0, 0));
                System.out.println(" 1- Play turn\n 2- My info");
                int optionTurn = reader2.nextInt(2);
                switch (optionTurn) {
                    case 1: {                        
                        int ale = dice.nextInt(6);
                        System.out.println("Your number is: " + ale);
                        
                        if (p1.getPosX() >= 0 && p1.getPosX() < 11) {
                            int position = p1.getPosX()+ale;
                            if (position > 11) {
                                p1.setPosX(11);
                                position-=11;
                            }
                            p1.setPosY(position);
                        }
                        System.out.println(gb.printBoard(p1.getUsername(), 0, ale));
                        
                        break;
                    }
                    case 2:{
                        
                    }
                }

                break;
            case 2:
                System.exit(0);
                break;
        }

    }
}
