package Data;

import java.util.ArrayList;
/**
 *
 * @author - Juan Ochoa
 *         - Diego Ruiz
 */
public class Board {
    private static Square[][] gameBoard;
    private ArrayList<PropertyCard> properties = new ArrayList<>();
    private ArrayList<LuckyCard> luckyCards = new ArrayList<>();
    
    public Board() {
        PropertyCard bogota = new PropertyCard(3500,"    Bogotá    ");
        PropertyCard cartagena = new PropertyCard(3400,"   Cartagena  ");
        PropertyCard tayrona = new PropertyCard(3300,"Parque Tayrona");
        PropertyCard medellin = new PropertyCard(3200,"   Medellin   ");
        PropertyCard santaMarta = new PropertyCard(3100," Santa Marta  ");
        PropertyCard sanAndres = new PropertyCard(3000,"  San Andres  ");
        PropertyCard cali = new PropertyCard(2999,"     Cali     ");
        PropertyCard guatape = new PropertyCard(678,"   Guatape     ");
        PropertyCard barranquilla = new PropertyCard(2800," Barranquilla ");
        PropertyCard salento = new PropertyCard(456,"    Salento   ");
        PropertyCard villaLeyva = new PropertyCard(2600,"Villa de Leyva");
        PropertyCard taganga = new PropertyCard(2500,"    Taganga   ");
        PropertyCard popayan = new PropertyCard(2400,"    Popayan   ");
        PropertyCard manizales = new PropertyCard(2300,"  Manizales   ");
        PropertyCard sanAgustin = new PropertyCard(2200,"  San Agustin ");
        PropertyCard chicamocha = new PropertyCard(2100,"  Chicamocha  ");
        PropertyCard pereira = new PropertyCard(2000,"    Pereira   ");
        PropertyCard bucaramanga = new PropertyCard(1900,"  Bucaramanga ");
        PropertyCard sanGil = new PropertyCard(300,"    San Gil   ");
        PropertyCard leticia = new PropertyCard(1700,"    Leticia   ");
        PropertyCard armenia = new PropertyCard(1200,"    Armenia   ");
        PropertyCard chiquinquira = new PropertyCard(1555," Chiquinquira ");
        PropertyCard zipaquira = new PropertyCard(1454,"   Zipaquira  ");
        PropertyCard barichara = new PropertyCard(1373,"   Barichara  ");
        PropertyCard losNevados = new PropertyCard(744,"  Los Nevados ");
        PropertyCard pasto = new PropertyCard(1023,"     Pasto    ");
        PropertyCard rioHacha = new PropertyCard(567,"   Rio Hacha  ");
        PropertyCard ipiales = new PropertyCard(345,"    Ipiales   ");
        PropertyCard villavicencio = new PropertyCard(567," Villavicencio");
        PropertyCard cocuy = new PropertyCard(820,"   El cocuy   ");
        PropertyCard buenaventura = new PropertyCard(764," Buenaventura  ");  
        
        properties.add(bogota);
        properties.add(cartagena);
        properties.add(tayrona);
        properties.add(medellin);
        properties.add(santaMarta);
        properties.add(sanAndres);
        properties.add(cali);
        properties.add(guatape);
        properties.add(barranquilla);
        properties.add(salento);
        properties.add(villaLeyva);
        properties.add(taganga);
        properties.add(popayan);
        properties.add(manizales);
        properties.add(sanAgustin);
        properties.add(chicamocha);
        properties.add(pereira);
        properties.add(bucaramanga);
        properties.add(sanGil);
        properties.add(leticia);
        properties.add(armenia);
        properties.add(chiquinquira);
        properties.add(zipaquira);
        properties.add(barichara);
        properties.add(losNevados);
        properties.add(pasto);
        properties.add(rioHacha);
        properties.add(sanGil);
        properties.add(ipiales);
        properties.add(villavicencio);
        properties.add(cocuy);
        properties.add(buenaventura);
        
        LuckyCard jail = new LuckyCard("Jail","Exit to Jail", 0, 0, "Exit to Jail");
        LuckyCard bonus100 = new LuckyCard("Bonus","Received 100 dollars", 0, 100, "Bonus + $100");
        LuckyCard penalty150 = new LuckyCard("Penalty","You lose 150 dollars", 150, 0, "Penalty - $150");
        LuckyCard returnDice = new LuckyCard("Dice","Returns to roll the die", 150, 0, "Roll the die");
        LuckyCard bonus500 = new LuckyCard("Bonus","Received 500 dollars", 0, 500, "Bonus + $500");
        LuckyCard penalty450 = new LuckyCard("Penalty","You lose 450 dollars", 450, 0, "Penalty - $450");        
        LuckyCard bonus50 = new LuckyCard("Bonus","Received 50 dollars", 0, 50, "Bonus + $50");
        LuckyCard penalty70 = new LuckyCard("Penalty","You lose 70 dollars", 70, 0, "Penalty - $70");
        LuckyCard left3 = new LuckyCard("Left","Go to Left 3 Square", 0, 0, "Square -3");
        LuckyCard rigth3 = new LuckyCard("Rigth","Go to Right 3 Square", 0, 0, "Square +3");        
        
        luckyCards.add(jail);
        luckyCards.add(bonus100);
        luckyCards.add(penalty150);
        luckyCards.add(returnDice);
        luckyCards.add(bonus500);
        luckyCards.add(penalty450);
        luckyCards.add(bonus50);
        luckyCards.add(penalty70);
        luckyCards.add(left3);
        luckyCards.add(rigth3);
        
        int value = 0;
        gameBoard = new Square[11][11];
        for (int row = 0; row < gameBoard.length; row++)
        {
            for (int col = 0; col < gameBoard.length; col++) 
            {
                if((row==0&&col==5)||(row==5&&col==10)||(row==5&&col==0)||(row==10&&col==5))
                {
                    Square sqr = new Square(row, col, "  Lucky Card  ");
                    gameBoard[row][col]= sqr;
                }
                else if(row==0&&col==0)
                {
                    Square sqr = new Square(row, col, "|      GO      ");
                    gameBoard[row][col]= sqr;
                }
                else if(row==0&&col==10)
                {
                    Square sqr = new Square(row, col, "      JAIL    ");
                    gameBoard[row][col]= sqr;
                }
                else if(row==10&&col==0)
                {
                    Square sqr = new Square(row, col, "|  GO TO JAIL  ");
                    gameBoard[row][col]= sqr;
                }
                else if(row==10&&col==10)
                {
                    Square sqr = new Square(row, col, "   FREE STOP  ");
                    gameBoard[row][col]= sqr;
                }
                else if(row==0||row==10)
                {
                    PropertyCard card = properties.get(value++);
                    PropertySquare square = new PropertySquare(card.getCost(), card, row, col, card.getName());
                    gameBoard[row][col] = square; 
                }
                else if(col==0||col==10)
                {
                    PropertyCard card = properties.get(value++);
                    PropertySquare square = new PropertySquare(card.getCost(), card, row, col, card.getName());
                    gameBoard[row][col] = square; 
                }
                else
                {
                    
                }
            }
        }
    }

    public static Square[][] getGameBoard() {
        return gameBoard;
    }

    public static void setGameBoard(Square[][] gameBoard) {
        Board.gameBoard = gameBoard;
    }
    
    public String printBoard(String player, int r, int c) 
    {
        String printBoard = "\n";

        for (int row = 0; row < 11; row++) {
            printBoard = printBoard.concat("\t|");
            for (int col = 0; col < 11; col++) {
                
                if(row==r && col==c)
                {
                    printBoard = printBoard.concat("|"+player+"|");
                }
                else if((row==0||row==10))
                {
                    printBoard = printBoard.concat(
                        gameBoard[row][col].getName().concat("|"));
                }
                else if((col==0||col==10))
                {
                    printBoard = printBoard.concat("|".concat(
                        gameBoard[row][col].getName().concat("|")));
                }
                else
                {
                    printBoard = printBoard.concat("               ");
                }
                
            }
            printBoard = printBoard.concat("\n");
        }
        return printBoard;
    }
}
