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

        /*
         *   Generate MonopolyConsole
         *
         */
        MonopolyConsole console = new MonopolyConsole();
        console.welcome();

        /*
         *   Select numbers of players
         *
         */
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

                /*
                 *   Generate board
                 *
                 */
                Board gb = new Board();
                TurnController turn = new TurnController();

                /*
                 *   Selection of player
                 *
                 */
                int option;

                /*
                 *   Print to players
                 *
                 */
                System.out.println("\n\n ----- List of players -----");
                System.out.println("______________________________________");
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
                System.out.println("______________________________________");

                // Print to board for first time
                System.out.println(gb.printBoard(p1.getUsername(), 0, 0));
                Player player = p1;
                Player nextPlayer = p1;
                String playerName = p1.getUsername();
                // Play Game
                do {
                    System.out.println(playerName + " your turn");
                    System.out.println(" 1- Drop the dice\n 2- Information\n 3 - Give up");
                    option = reader2.nextInt(4);
                    switch (option) {
                        /*
                         *   Turns
                         *
                         */
                        case 1: {
                            if (turn.validatePlayer(p1) && p1.isHasTurn()) {
                                player = turn.playTurn(p1);
                                p1 = player;
                                if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                } else if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                } else if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                } else {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                }
                            } else if (turn.validatePlayer(p2) && p2.isHasTurn()) {
                                player = turn.playTurn(p2);
                                p2 = player;
                                if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                } else if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                } else if (turn.validatePlayer(p1)) {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                } else {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                }
                            } else if (turn.validatePlayer(p3) && p3.isHasTurn()) {
                                player = turn.playTurn(p3);
                                p3 = player;
                                if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                } else if (turn.validatePlayer(p1)) {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                } else if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                } else {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                }
                            } else if (turn.validatePlayer(p4) && p4.isHasTurn()) {
                                player = turn.playTurn(p4);
                                p4 = player;
                                if (turn.validatePlayer(p1)) {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                } else if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                } else if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                } else {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                }
                            } else {
                                System.out.println("Logical error in play turn -- > --validate users--");
                            }
                            System.out.println(gb.printBoard(player.getUsername(), player.getPosY(), player.getPosX()));

                            break;

                        }
                        /*
                         *   Player info
                         *
                         */
                        case 2: {
                            if (p1.isHasTurn()) {
                                p1.printPlayer();
                            } else if (p2.isHasTurn()) {
                                p2.printPlayer();
                            } else if (p3.isHasTurn()) {
                                p3.printPlayer();
                            } else if (p4.isHasTurn()) {
                                p4.printPlayer();
                            }
                            break;
                        }
                        /*
                         *   Player give up
                         *
                         */
                        case 3: {
                            if (p1.isHasTurn()) {
                                p1 = turn.giveUp(p1);
                                if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                } else if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                } else if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                } else {
                                    System.out.println("Thank you so much for play Monopoly Colombia!");
                                }
                            } else if (p2.isHasTurn()) {
                                p2 = turn.giveUp(p2);
                                if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                } else if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                } else if (turn.validatePlayer(p1)) {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                } else {
                                    System.out.println("Thank you so much for play Monopoly Colombia!");
                                }
                            } else if (p3.isHasTurn()) {
                                p3 = turn.giveUp(p3);
                                if (turn.validatePlayer(p4)) {
                                    p4.setHasTurn(true);
                                    playerName = p4.getUsername();
                                } else if (turn.validatePlayer(p1)) {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                } else if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                } else {
                                    System.out.println("Thank you so much for play Monopoly Colombia!");
                                }
                            } else if (p4.isHasTurn()) {
                                p4 = turn.giveUp(p4);
                                if (turn.validatePlayer(p1)) {
                                    p1.setHasTurn(true);
                                    playerName = p1.getUsername();
                                } else if (turn.validatePlayer(p2)) {
                                    p2.setHasTurn(true);
                                    playerName = p2.getUsername();
                                } else if (turn.validatePlayer(p3)) {
                                    p3.setHasTurn(true);
                                    playerName = p3.getUsername();
                                } else {
                                    System.out.println("Thank you so much for play Monopoly Colombia!");
                                }
                            }
                            break;
                        }
                    }

                } while (!p1.isGiveUp() || !p2.isGiveUp() || !p3.isGiveUp() || !p4.isGiveUp());

        }
    }
}
