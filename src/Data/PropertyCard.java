/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Juan Ochoa
 */
public class PropertyCard extends Card{
    
    
    private int cost;
    private double rent;
    private double mortgageValue;

    public PropertyCard(int cost, String name) {
        super(name);
        this.cost = cost;
        this.rent = cost*0.2;
        this.mortgageValue = cost/2;
    }
    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getMortgageValue() {
        return mortgageValue;
    }

    public void setMortgageValue(double mortgageValue) {
        this.mortgageValue = mortgageValue;
    }
}
