/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Data.Square;

/**
 *
 * @author Juan Ochoa
 */
public class TurnController 
{
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
    
}
