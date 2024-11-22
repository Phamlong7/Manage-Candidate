/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Candidate;
import View.MainMenu;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Main {
    
    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        MainMenu.mainMenu(candidates);
    }
}
