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
 * @author christopher.eckles
 */
public final class InputChecker {
    private int minSize = 0;
    private int maxSize = 20;
    private int feedbackSetPosition;

    private String[] forbiddenStrings; // "*'`" 
    private String[] requiredStrings; // "!@#$%^&*()","COM"
    
    private String[][] feedbackSet;

    public InputChecker(){
        
    }
    
    public InputChecker(int minimumSize, int maximumSize){
        setMinSize(minimumSize);
        setMaxSize(maximumSize);
    }
    
    /**
     * takes in an array of strings that would be required to validate the input.
     * @param req 
     */
    public void setRequiredStrings(String[] req) {
        requiredStrings = req;
    }

    public boolean checkInput(String input) throws ServiceConfigurationError {
        feedbackSet = new String[requiredStrings.length * 2][2];
        feedbackSetPosition = 0;

        
        //Check Minimum Size
        if (input.length() < minSize) {
            setFeedback(Feedback.ERROR_MIN_SIZE, "Expected: " + String.valueOf(minSize) + " Required:" +  String.valueOf(input.length()));
        }
        //Check Maximum Size
        
        //Check Forbiden Characters
        
        //Check Required Characters
        if (requiredStrings == null) {
            throw new ServiceConfigurationError("Required Characters are not set.");
        } else if (minSize == 0) {
            throw new ServiceConfigurationError("Minimum size not set.");
        } else {

            boolean meets = false;

            for (int i = 0; i < requiredStrings.length; i++) {
                boolean contains = false;

                for (int p = 0; p < input.length(); p++) {
                    if (requiredStrings[i].contains(input.subSequence(p, p))) {
                        contains = true;

                        break;
                    }

                }
                if (contains == false) {
                    meets = false;

                }
            }
            if (meets == false) {

            }
            return meets;
        }

    }

    public int getMinSize() {
        return minSize;
    }

    /**
     * Sets Minimum Input Size.
     * This must be set for the validating to work.
     * @param mnSize minimum input size for validation.
     */
    public void setMinSize(int mnSize) {
        if(mnSize > 0 && mnSize <= maxSize){
            minSize = mnSize;
        }
    }
    
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Sets Maximum Input Size
     * This maxSize is defaulted to 20 characters.
     * @param mxSize integer to set the maximum input size for validation
     */
    public void setMaxSize(int mxSize) {
        maxSize = mxSize;
    }

    /**
     *  This method retrieves the feedback regarding the most recent input validation.
     * @return multidimensional String Array containing messages and offending values.
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
