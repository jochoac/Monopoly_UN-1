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
public class Card {
    
    private String name;

    public Card(String name) {
        this.name = name;
    }
    
    public void print(){
        System.out.println("Name: " + this.name);
    };
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
