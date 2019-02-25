/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.components.interfaces;

import java.util.HashMap;

/**
 *
 * @author christopher.eckles
 */
public interface Portable {
    public abstract HashMap export();    
    public abstract void load(HashMap map);    

}
