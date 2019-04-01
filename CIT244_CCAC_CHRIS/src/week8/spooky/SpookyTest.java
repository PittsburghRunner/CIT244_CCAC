/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8.spooky;

import java.util.Random;

/**
 *
 * @author christopher.eckles
 */
public class SpookyTest {
    //Change this guy to increase or decrease the levels. 
    //Affects number of zombie wars waged.
    private static final int LEVELS = 10;
    private static final String SPACING = "     ";
    
    private static int outerId = 1;
    private static int innerId = 1;

    private int id;
    private int ghost = 5;
    private int zombie = 10;
    

    public SpookyTest() {
        id = outerId;
        outerId++;
        System.out.println(indent(id) + id + " Start Outer Constructor");
        new Inside(id);
        System.out.println(indent(id) + id + " End Outer Constructor");
        if(id < LEVELS ){
            wageZombieWar();
        }
    }
    //this guy is inside the outsid class
    class Inside {

        public Inside(int outId) {
            id = innerId;
            innerId++;
            System.out.println(indent(outId+1) + id + " Start Inner Constructor");
            access(outId);
            System.out.println(indent(outId+1) + id + " End Inner Constructor");

        }
        private int zombie = 8;
        private int id;

        private void access(int outId) {
            System.out.println(indent(outId+2) + id + " Begin Access");
            System.out.println(indent(outId+2) + "    Ghost: " + ghost);
            System.out.println(indent(outId+2) + "    Zombie: " + zombie);
            System.out.println(indent(outId+2) + id + " End Access");

        }
    }//end inside class

    public static void main(String[] args) {
        SpookyTest ip = new SpookyTest();
        //ip.wageZombieWar();

    }

    private void wageZombieWar() {
        System.out.println(indent(id) + id + " Begin War");
        new Inside(id);
        new SpookyTest();
        System.out.println(indent(id) + id + " End War");

    }

    public static String indent(int id) {
        
        String indent = "";
        for (int i = 1; i < id; i++) {
            indent = indent + SPACING;

        }
        return indent;
    }
}
