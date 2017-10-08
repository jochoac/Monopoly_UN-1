package UI;

import BusinessLogic.TurnController;
import Data.Board;
import Data.Player;
import java.util.ArrayList;

/**
 *
 * @author - Juan Ochoa - Diego Ruiz
 */
public class MonopolyTest {

    static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {

        //  *   Generate Monopoly in console       
        MonopolyConsole console = new MonopolyConsole();
        console.welcome();

        //  *   Options
        switch (console.getOption()) {
            case 1: // New game
                console.selectionPlayers();
                int cantPlayers = console.getCantPlayers();

                if (cantPlayers > 0) {

                    System.out.print("\nWrite username for player 1:  | ");
                    console.inputLine();
                    players.add(new Player(console.getLine(), true, 2205, 0, 0, false));

                    for (int i = 1; i < cantPlayers; i++) {
                        System.out.print("\nWrite username for player " + (i + 1) + ":  | ");
                        console.inputLine();
                        players.add(i, new Player(console.getLine(), false, 2205, 0, 0, false));
                    }

                } else {
                    System.out.println("Try again!");
                }

                // Generate Board
                Board gb = new Board();
                TurnController turn = new TurnController();
                int option;

                // Print to players
                System.out.println("\n\n ----- List of players -----");
                System.out.println("______________________________________");
                for (Player player : players) {
                    System.out.println(player.getUsername());
                }
                System.out.println("______________________________________");

                // Play Game
                do {
                    // Player turn
                    for (Player player : players) {

                        player.setHasTurn(true);

                        while (player.isHasTurn() && !player.isGiveUp()) {

                            System.out.println(player.getUsername() + " your turn");
                            console.options("Player Options");

                            switch (console.getOption2()) {
                                case 1: {
                                    player = turn.playTurn(player);
                                    System.out.println(gb.printBoard(player.getUsername(), player.getPosY(), player.getPosX()));
                                    break;
                                }
                                case 2: {
                                    player.printPlayer();
                                    break;
                                }
                                case 3: {                                                                        
                                    player = turn.giveUp(player);
                                    break;
                                }
                            }
                        }
                    }
                } while (!players.isEmpty());
        }
    }
}
