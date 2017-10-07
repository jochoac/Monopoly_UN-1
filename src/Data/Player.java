package Data;

import java.util.ArrayList;

/**
 *
 * @author - Juan Ochoa
 *         - Diego Ruiz
 */
public class Player{
    
    private String username;
    private boolean hasTurn;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<PropertyCard> propertys = new ArrayList<>();
    private int money;
    private int posX;
    private int posY;
    private boolean giveUp;

    public Player(String username, boolean hasTurn, int money, int posX, int posY, boolean giveUp) {
        this.username = username;
        this.hasTurn = hasTurn;
        this.money = money;
        this.posX = posX;
        this.posY = posY;
        this.giveUp = giveUp;
    }
    
    public void printPlayer(){
        System.out.println("___________________________");
        System.out.println(" ** Player info: ");
        System.out.println(this.getUsername());
        System.out.println("Your money: $" + this.getMoney() + " Dollars");
        System.out.println("Your propertys");
        for (PropertyCard property : this.propertys) {
            System.out.println(property);
        }
        System.out.println("Your lucky cards");
        for (Card card : this.cards) {
            System.out.println(card);
        }
        System.out.println("___________________________");
        
    }
    
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHasTurn() {
        return hasTurn;
    }

    public void setHasTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isGiveUp() {
        return giveUp;
    }

    public void setGiveUp(boolean giveUp) {
        this.giveUp = giveUp;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public ArrayList<PropertyCard> getPropertys() {
        return propertys;
    }

    public void setPropertys(ArrayList<PropertyCard> propertys) {
        this.propertys = propertys;
    }    
}
