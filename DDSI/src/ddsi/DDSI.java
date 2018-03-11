/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsi;

import GUI.View;

/**
 *
 * @author juanc
 */
public class DDSI {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User u = new User("user", "1234", "b@gmail.com");
        View v = new View(u);
        v.setVisible(true);
        
        System.out.println("End");
    }
    
}
