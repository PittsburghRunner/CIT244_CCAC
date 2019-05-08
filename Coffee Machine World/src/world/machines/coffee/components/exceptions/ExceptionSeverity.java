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
public enum ExceptionSeverity {
    COSMETIC("Cosmetic - Continuing with process",0),
    LOW("Low - User Intervention Required",3),
    MODERATE("Moderate - User Intervention Required",6),
    CATASTROPHIC("Catastrophic - Maintenance Needed",9);

    String name;
    int value;    
    
    ExceptionSeverity(String n, int v){
        name=n;
        value=v;
    }
}
