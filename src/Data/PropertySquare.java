package Data;

/**
 *
 * @author - Juan Ochoa
 *         - Diego Ruiz
 */
public class PropertySquare extends Square
{
    private int cost;
    private PropertyCard card;

    public PropertySquare(int cost, PropertyCard card, int row, int col, String name) {
        super(row, col, name);
        this.cost = cost;
        this.card = card;
    }
    
 
    public PropertyCard getCard() {
        return card;
    }

    public void setCard(PropertyCard card) {
        this.card = card;
    }
    
    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }  
    
    
}
