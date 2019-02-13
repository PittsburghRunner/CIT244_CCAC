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

        System.out.println("Setting Max");
        ic.setMaxSize(8);

        System.out.println("Setting Min");
        ic.setMinSize(4);

        System.out.println("Setting Req");
        ic.setRequiredStrings(new String[]{"!@#$%^&*()", "QWERTYUIOPASDFGHJKLZXCVBNM", "qwertyuiopasdfghjklzxcvbnm", "1234567890"});

        System.out.println("Setting Forbidden");
        ic.setForbiddenStrings(new String[]{"'~`?<>\";"});

        for (int i = 0; i < inputsToCheck.length; i++) {
            System.out.println("Checking " + i );
            String input = inputsToCheck[i];
            System.out.println("Running Check");
            boolean meets = ic.checkInput(input);

            if (meets) {
                System.out.println("SUCCESSS! The password: " + input + " meets requirements!");
            }
        }

    }

}
