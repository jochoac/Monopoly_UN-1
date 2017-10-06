package UI;

import BusinessLogic.TurnController;
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
    private static Player p1 = new Player(null, false, 200, 0, 0, false);
    private static Player p2 = new Player(null, false, 200, 0, 0, true);
    private static Player p3 = new Player(null, false, 200, 0, 0, true);
    private static Player p4 = new Player(null, false, 200, 0, 0, true);

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
                    p1 = new Player(name, true, 2205, 0, 0, false);
                    if (b >= 2) {
                        System.out.println("Write username for player 2");
                        String name2 = reader2.nextLine();
                        p2 = new Player(name2, false, 2205, 0, 0, false);
                        if (b >= 3) {
                            System.out.println("Write username for player 3");
                            String name3 = reader2.nextLine();
                            p3 = new Player(name3, false, 2205, 0, 0, false);
                            if (b == 4) {
                                System.out.println("Write username for player 4");
                                String name4 = reader2.nextLine();
                                p4 = new Player(name4, false, 2205, 0, 0, false);
                            }
                        }
                    }
                }
                Board gb = new Board();
                Random dice = new Random();
                TurnController turn = new TurnController();
                int option;

                System.out.println("List of players:");

                if (turn.validatePlayer(p1)) {
                    System.out.println(p1.getUsername());
                }
                if (turn.validatePlayer(p2)) {
                    System.out.println(p2.getUsername());
                }
                if (turn.validatePlayer(p3)) {
                    System.out.println(p3.getUsername());
                }
                if (turn.validatePlayer(p4)) {
                    System.out.println(p4.getUsername());
                }
                System.out.println(gb.printBoard(p1.getUsername(), 0, 0));
                do {
                    Player player = new Player("default", false, 0, -1, 0, true);
                    System.out.println(" 1- Play turn\n 2- My info\n 3 - Give up");
                    option = reader2.nextInt(3);
                    switch (option) {
                        case 1: {
                            if (turn.validatePlayer(p1) && p1.isHasTurn()) {
                                player = turn.playTurn(p1);
                                p1 = player;
                                if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                } else {
                                    p1.setHasTurn(true);
                                }
                            } else if (turn.validatePlayer(p2) && p2.isHasTurn()) {
                                player = turn.playTurn(p2);
                                p2 = player;
                                if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                } else {
                                    p1.setHasTurn(true);
                                }
                            } else if (turn.validatePlayer(p3) && p3.isHasTurn()) {
                                player = turn.playTurn(p3);
                                p3 = player;
                                if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                }else{
                                    p1.setHasTurn(true);
                                }
                            } else if (turn.validatePlayer(p4) && p4.isHasTurn()) {
                                player = turn.playTurn(player);
                                p4 = player;                                
                                p1.setHasTurn(true);
                            } else {
                                System.out.println("Error lógico en validación de usuarios");
                            }
                            System.out.println(gb.printBoard(player.getUsername(), player.getPosY(), player.getPosX()));

                            break;

                        }

                        case 2: {
                            // Info user
                            break;
                        }
                        case 3: {
                            if (p1.isHasTurn()) {
                                p1.setGiveUp(true);
                            } else if (p2.isHasTurn()) {
                                p2.setGiveUp(true);
                            } else if (p3.isHasTurn()) {
                                p3.setGiveUp(true);
                            } else if (p4.isHasTurn()) {
                                p4.setGiveUp(true);
                            }
                            break;
                        }
                    }

                } while (!p1.isGiveUp() || !p2.isGiveUp() || !p3.isGiveUp() || !p4.isGiveUp());

        }
    }
}
