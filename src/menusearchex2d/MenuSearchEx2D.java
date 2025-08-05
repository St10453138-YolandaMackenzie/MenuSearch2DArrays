
package menusearchex2d;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Arrays;
/**
 *
 * @author lab_services_student
 */
public class MenuSearchEx2D {

    public static void main(String[] args) {
        // Start of my code
        //Decalaring a variable
        String[] menuChoices = new String[10];
        
        //Variables for input and tracking progress
        String entry = "";
        String menuString = "";
        int x = 0;
        int numEntered;
        int highestSub = menuChoices.length - 1;
        
        //Fill array with placeholder values to ensure sorting/ searching works
        Arrays.fill(menuChoices, "zzzzzzz"); //Use high-value "zzzzzz" for sorting array
        
        //Prompt the user for the first menu item
        menuChoices[x] = JOptionPane.showInputDialog(null,
                "Enter an item for today's menu, or zzz to quit");
        
        //Loop to collect up to 10 menu items, stop if "zzz" is entered
        while (!menuChoices[x].equals("zzz") && x < highestSub) {
        menuString = menuString + menuChoices[x] + "\n"; //Add items to display string
        ++x; //Move to next array position
        if (x < highestSub) {
            //Prompt for next item
            menuChoices[x] = JOptionPane.showInputDialog(null,
                    "Enter an item for today's menu, or zzz to quit");
           }
        }
        //Store number of valid entries (excluding placeholder "zzz")
        numEntered = x;
        //Ask user to choose an item from the collected item
        entry = JOptionPane.showInputDialog(null,
                "Today's menu is:\n" + menuString +
                        "Please make a selection");
        
        //Sort the entered items only (ignore "zzzzzzz" placeholders)
        Arrays.sort(menuChoices, 0, numEntered);
        
        //Search for user's choice in the sorted array
        x = Arrays.binarySearch(menuChoices, entry);
        
        //If the entry was found within the valid entered range
        if (x >= 0 && x < numEntered)
            JOptionPane.showMessageDialog(null, "Excellent choice");
        else
            JOptionPane.showMessageDialog(null,
                    "Sorry - that item is not on tonight's menu");
            
                   
        }
    }
    
    

