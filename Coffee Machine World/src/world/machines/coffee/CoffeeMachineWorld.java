/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.machines.coffee;

import java.util.logging.Level;
import java.util.logging.Logger;
import world.machines.coffee.components.exceptions.ModeException;
import world.thermoDynamics.HeatDissipator;

/**
 *
 * @author christopher.eckles
 */
public class CoffeeMachineWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        
        HeatDissipator hd = new HeatDissipator(cm);
        //thread for cooling water down
        hd.start();
        System.out.println("Good Moring Mr Grumpy Gills. \nHow about a nice cup of coffee?");
        
        try {
            while(true){
                cm.containerAvailable = true;
               cm.makeCoffee(8);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CoffeeMachineWorld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ModeException ex) {
            Logger.getLogger(CoffeeMachineWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
