/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.input.validation;

import java.util.Arrays;
import java.util.ServiceConfigurationError;

/**
 * This class
 *
 * @author christopher.eckles
 */
public final class InputChecker {

    private int minSize = 0;
    private int maxSize = 20;
    private int feedbackSetPosition;

    private String[] forbiddenStrings; // "*'`" 
    private String[] requiredStrings; // "!@#$%^&*()","COM"

    private String[][] feedbackSet;

    public InputChecker() {

    }

    /**
     * Constructor for the input checker. Requires a minimum and maximum size.
     *
     * @param minimumSize
     * @param maximumSize
     */
    public InputChecker(int minimumSize, int maximumSize) {
        setMinSize(minimumSize);
        setMaxSize(maximumSize);
    }

    /**
     * takes in an array of strings that would be required to validate the
     * input.
     *
     * @param req
     */
    public void setRequiredStrings(String[] req) {
        requiredStrings = req;
    }

    /**
     * takes in an array of strings that would be forbidden to validate the
     * input.
     *
     * @param req
     */
    public void setForbiddenStrings(String[] req) {
        requiredStrings = req;
    }

    public boolean checkInput(String input) throws ServiceConfigurationError {
        feedbackSet = new String[requiredStrings.length * 2][2];
        feedbackSetPosition = 0;

        //Check for null
        System.out.println("Checking for null");
        if (input == null || input.length() == 0) {
            return false;
        }

        //Check Minimum Size
        System.out.println("Check Minimum Size");
        if (input.length() < minSize) {
            setFeedback(Feedback.ERROR_MIN_SIZE, "Expected: " + String.valueOf(minSize) + " Received:" + String.valueOf(input.length()));
        }
        //Check Maximum Size
        System.out.println("Check Maximum Size");
        if (input.length() > maxSize) {
            setFeedback(Feedback.ERROR_MAX_SIZE, "Expected: " + String.valueOf(maxSize) + " Received:" + String.valueOf(input.length()));
        }

        //Check Required Characters
        System.out.println("Check Required Characters");
        if (requiredStrings == null) {
            throw new ServiceConfigurationError("Required Characters are not set.");
        } else if (minSize == 0) {
            throw new ServiceConfigurationError("Minimum size not set.");
        } else {

            boolean meets = false;

            for (int i = 0; i < requiredStrings.length; i++) {
                boolean contains = false;
                String rs = requiredStrings[i];
                for (int p = 0; p < rs.length(); p++) {
                    CharSequence character = rs.subSequence(p, p + 1);
                    if (input.contains(character)) {
                        contains = true;
                    }
                }

                if (contains == false) {
                    setFeedback(Feedback.ERROR_REQUIRED_STRING, "Expected: " + rs);
                    meets = false;
                }
            }

            //Check Forbiden Characters
            System.out.println("Check Forbidden Characters");
            for (int i = 0; i < forbiddenStrings.length; i++) {
                boolean contains = false;
                String fs = forbiddenStrings[i];
                for (int p = 0; p < fs.length(); p++) {
                    CharSequence character = fs.subSequence(p, p + 1);
                    if (input.contains(character)) {
                        contains = true;
                        setFeedback(Feedback.ERROR_FORBIDDEN_STRING, "Not Expected: " + character);
                    }
                }

                if (contains == true) {
                    meets = false;
                }
            }

            if (meets == false) {
                setFeedback(Feedback.FAILURE, "");
            }
            {
                setFeedback(Feedback.SUCCESS, "");
                return meets;
            }

        }

    }

    public int getMinSize() {
        return minSize;
    }

    /**
     * Sets Minimum Input Size. This must be set for the validating to work.
     *
     * @param mnSize minimum input size for validation.
     */
    public void setMinSize(int mnSize) {
        if (mnSize > 0 && mnSize <= maxSize) {
            minSize = mnSize;
        }
    }

    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Sets Maximum Input Size This maxSize is defaulted to 20 characters.
     *
     * @param mxSize integer to set the maximum input size for validation
     */
    public void setMaxSize(int mxSize) {
        maxSize = mxSize;
    }

    /**
     * This method retrieves the feedback regarding the most recent input
     * validation.
     *
     * @return multidimensional String Array containing messages and offending
     * values.
     */
    public String[][] getFeedback() {
        return feedbackSet;
    }

    private void setFeedback(Feedback fb, String detail) {

        if (feedbackSetPosition + 1 == feedbackSet.length) {
            feedbackSet = Arrays.copyOf(feedbackSet, feedbackSet.length * 2);
        }
        feedbackSet[feedbackSetPosition][0] = fb.getCode();
        feedbackSet[feedbackSetPosition][1] = detail;
        feedbackSetPosition++;
    }
}
