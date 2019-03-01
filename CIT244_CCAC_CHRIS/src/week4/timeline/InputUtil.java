/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline;

import java.util.Scanner;

/**
 *
 * @author ceckles
 */
public class InputUtil {

    public static int waitForIntInput(int max) {
        Scanner inputScanner = new Scanner(System.in);

        int input = -1;
        while (input == -1 || input > max) {
            System.out.print("Type your selection: ");
            try {
                input = inputScanner.nextInt();
            } catch (Exception e) {
                System.out.println("Bad Input");
                return input;
            }
        }

        return input;
    }
}
