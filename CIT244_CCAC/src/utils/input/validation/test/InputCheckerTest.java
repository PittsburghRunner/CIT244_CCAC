/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.input.validation.test;

import utils.input.validation.InputChecker;

/**
 *
 * @author christopher.eckles
 */
public class InputCheckerTest {
    public static void main(String[] args) {
        InputChecker ic = new InputChecker();
        
        ic.setMaxSize(8);
        ic.setMinSize(4);
        ic.setRequiredStrings(new String[]{"!@#$%^&*()","QWERTYUIOPASDFGHJKLZXCVBNM","qwertyuiopasdfghjklzxcvbnm","1234567890"});
    }
            
}
