/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Player;
import Data.Square;
import java.util.Random;

/**
 *
 * @author Juan Ochoa
 */
public class TurnController {

    private Square startPoint;
    private Square endPoint;
    private int numberOfMoves;

    public Square getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Square startPoint) {
        this.startPoint = startPoint;
    }

    public Square getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Square endPoint) {
        this.endPoint = endPoint;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public boolean validatePlayer(Player player) {
        return !player.isGiveUp();
    }
    
    

    public Player playTurn(Player player) {

        int x, y;
        int numberDice;
        
        Random dice = new Random();
        do {
            numberDice = dice.nextInt(6);
        } while (numberDice == 0);
        
        System.out.println(" --------- > Your number is: " + numberDice);
        if (player.getPosY() == 0 && player.getPosX() < 11) {
            x = player.getPosX();
            if (x + numberDice > 10) {
                y = (x + numberDice) - 10;
                x = 10;
                player.setPosY(y);
                player.setPosX(x);
            } else {
                player.setPosX(x + numberDice);
            }
        } else if (player.getPosX() == 10 && player.getPosY() < 11) {
            y = player.getPosY();
            if (y + numberDice > 10) {
                x = player.getPosX() - numberDice;
                y = 10;
                player.setPosX(x);
                player.setPosY(y);
            } else {
                player.setPosY(y + numberDice);
            }
        } else if (player.getPosY() == 10 && player.getPosX() < 11) {
            x = player.getPosX();
            if (x - numberDice < 0) {
                y = player.getPosY() - numberDice;
                x = 0;
                player.setPosY(y);
                player.setPosX(x);
            } else {
                player.setPosX(x - numberDice);
            }
        } else if (player.getPosX() == 0 && player.getPosY() < 11) {
            y = player.getPosY();
            if (y - numberDice < 0) {
                x = player.getPosX() + numberDice;
                y = 0;
                player.setPosY(y);
                player.setPosX(x);
            } else {
                player.setPosY(y - numberDice);
            }
        }
        player.setHasTurn(false);

        return player;

    }
    
    public Player giveUp(Player player){
        player.setGiveUp(true);
        player.setHasTurn(false);
        return player;
    }
    
}
