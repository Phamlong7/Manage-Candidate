/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.Controller;
import Model.Candidate;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class MainMenu {
    
    // case manager when user input 
    public static void mainMenu(ArrayList<Candidate> candidates) {
        while (true) {
            int choice = Menu.menu();
            switch (choice) {
                case 1:
                    Controller.CreateCandidate(candidates, 0);
                    break;
                case 2:
                    Controller.CreateCandidate(candidates, 1);
                    break;
                case 3:
                    Controller.CreateCandidate(candidates, 2);
                    break;
                case 4:
                    Controller.SearchCandidate(candidates);
                    break;
                case 5:
                    return;
            }
        }
    }
}
