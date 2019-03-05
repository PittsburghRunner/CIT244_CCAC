/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 *
 * @author ceckles
 */
public class InputUtil {

    public static int waitForIntInput(int min, int max, int preset) {
        Scanner inputScanner = new Scanner(System.in);

        int input = -1;
        while (input < min || input > max) {
            if (preset != 0) {
                System.out.print("Type 0 to keep your previous entry (" + preset + "): ");
            }
            try {

                input = inputScanner.nextInt();
                if (input == 0 && preset != 0) {
                    return preset;
                }
            } catch (Exception e) {
                System.out.println("Bad Input. Try agin.");
            }
        }
        return input;
    }

    public static String waitForStringInput(int min, int max, String preset) {
        Scanner inputScanner = new Scanner(System.in);

        String input = "";
        while (input.length() < min || input.length() > max) {
            if (preset != null) {
                System.out.print("Type 0 to keep your previous entry (" + preset + "): ");
            }
            try {
                input = inputScanner.next();
                if (input.equals("0") && preset != null) {
                    return preset;
                }
            } catch (Exception e) {
                System.out.println("Bad Input. Try again.");
            }

        }
        return input;
    }

    public static Date waitForDateInput(int min, int max, Date preset) throws ParseException {
        Scanner inputScanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        SimpleDateFormat sdfyear = new SimpleDateFormat("yyyy");
        sdfyear.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        Date minDate = sdfyear.parse(String.valueOf(min));
        Date maxDate = sdfyear.parse(String.valueOf(max));

        Date date = sdfyear.parse("9999");
        String input = "";

        while (date.compareTo(minDate) < 0 || date.compareTo(maxDate) > 0) {
            if (preset != null) {
                System.out.print("Type 0 to keep your previous entry (" + preset + "): ");
            }
            try {
                input = inputScanner.next();
                if (input.equals("0") && preset != null) {
                    return preset;
                }
                date = sdf.parse(input);
            } catch (ParseException e) {
                System.out.println("Invalid Date format. Try again. (YYYY-MM-DD)");
            }
        }
        return date;
    }
}
