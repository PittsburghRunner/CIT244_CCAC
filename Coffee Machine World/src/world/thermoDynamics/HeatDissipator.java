/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.thermoDynamics;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.machines.coffee.CoffeeMachine;

/**
 *
 * @author ceckles
 */
public class HeatDissipator extends Thread {

    CoffeeMachine cm;

    public HeatDissipator(CoffeeMachine here) {
        cm = here;
    }
    
    @Override
    public void run(){
        try {
            dissipate();
        } catch (InterruptedException ex) {
            Logger.getLogger(HeatDissipator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dissipate() throws InterruptedException {
        while (true) {
            TimeUnit.SECONDS.sleep(10);
            if (cm.getWaterTemperature() > CoffeeMachine.ROOM_TEMP) {
                cm.decrementWaterTemperature(5);
                System.out.println("The Water Is Getting Colder");
            }

        }
    }
}
