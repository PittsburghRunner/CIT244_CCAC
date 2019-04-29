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
public class ModeException extends Exception{
    
    
    private ExceptionSeverity severity;
    
    public ModeException(String msg, ExceptionSeverity s){
       super(msg);
       severity = s;
    }

    public ExceptionSeverity getSeverity() {
        return severity;
    }


}
