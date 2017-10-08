/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author darui
 */
public interface ui {
    
    public Scanner reader = new Scanner(System.in);    
    
    void welcome();    
    void options(String option);
    
    
}
