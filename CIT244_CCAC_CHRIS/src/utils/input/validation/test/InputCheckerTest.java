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
        String inputsToCheck[] = new String[]{"test", "test1", "test!", "Test!34"};
        InputChecker ic = new InputChecker();

        ic.setMaxSize(8);
        ic.setMinSize(4);
        ic.setRequiredStrings(new String[]{"!@#$%^&*()", "QWERTYUIOPASDFGHJKLZXCVBNM", "qwertyuiopasdfghjklzxcvbnm", "1234567890"});
        ic.setForbiddenStrings(new String[]{"'~`?<>\";"});

        for (int i = 0; i < inputsToCheck.length; i++) {
            String input = inputsToCheck[i];
          Boolean meets =  ic.checkInput(input);
          
          if(meets){
              System.out.println("SUCCESSS! The password: " + input + " meets requirements!");
          }
        }

    }

}
