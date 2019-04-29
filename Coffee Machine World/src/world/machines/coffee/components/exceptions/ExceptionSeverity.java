/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.machines.coffee.components.exceptions;

/**
 *
 * @author christopher.eckles
 */
enum ExceptionSeverity {
    COSMETIC("Cosmetic",0),
    LOW("Low",3),
    MODERATE("Moderate",6),
    CATASTROPHIC("Catastrophic",9);

    String name;
    int value;    
    
    ExceptionSeverity(String n, int v){
        name=n;
        value=v;
    }
}
