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
public class LuckyCard extends Card{
    private String description;
    private int penalty;
    private int bonus;
    private String type; // 1 - Jail / 2 - Bonus / 3 - Penalty / 4 - Left / 5 - Right

    public LuckyCard(String type, String description, int penalty, int bonus, String name) {
        super(name);
        this.type = type;
        this.description = description;
        this.penalty = penalty;
        this.bonus = bonus;        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
