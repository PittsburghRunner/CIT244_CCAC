/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.password;

import java.util.ServiceConfigurationError;

/**
 *
 * @author christopher.eckles
 */
public class StrengthChecker {

    public static final String ERROR = "The password has not met the following requirement(s).";
    public static final String ERROR_MIN_PASSWORD = "\nMinimum size of ";
    public static final String ERROR_REQUIRED_STRING = "\nMust contain one of the following:";


    private static int minPasswordSize;

    private static String[] requiredStrings;
    private static String errors;

    public static void setRequiredStrings(String[] req) {
        requiredStrings = req;
    }

    public static boolean checkPassword(String password) throws ServiceConfigurationError {
        StringBuilder errorSB = new StringBuilder();

        errorSB.append(ERROR);

        if (password.length() < minPasswordSize) {
            errorSB.append(ERROR_MIN_PASSWORD).append(minPasswordSize).append(".");
        }

        if (requiredStrings == null) {
            throw new ServiceConfigurationError("Required Characters are not set.");
        } else if (minPasswordSize == 0) {
            throw new ServiceConfigurationError("Minimum password size not set.");
        } else {

            boolean meets = false;

            for (int i = 0; i < requiredStrings.length; i++) {
            boolean contains = false;

                for (int p = 0; p < password.length(); p++) {
                    if (requiredStrings[i].contains(password.subSequence(p, p))) {
                        contains = true;
                    }

                }
                if (contains == false) {
                    meets = false;
                    errorSB.append(ERROR_REQUIRED_STRING).append("(").append(requiredStrings[i]).append(")");
                }
            }
            if (meets == false){
                errors = errorSB.toString();
            }
            return meets;
        }

    }

    public static int getMinPasswordSize() {
        return minPasswordSize;
    }

    public static void setMinPasswordSize(int minSize) {
       minPasswordSize = minSize;
    }

    public static String getErrors() {
        return errors;
    }

}
