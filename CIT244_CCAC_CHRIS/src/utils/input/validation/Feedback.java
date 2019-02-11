/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.input.validation;

/**
 *
 * @author christopher.eckles
 */
public enum Feedback {
    ERROR_MIN_SIZE("N", "Minimum Size", "The input does not meet the minimum size set."),
    ERROR_MAX_SIZE("X", "Maximum Size", "The input exceeds the maximum size set."),
    ERROR_REQUIRED_STRING("R", "String Required", "The input did not contain the required string."),
    ERROR_FORBIDDEN_STRING("F", "String Forbidden", "The input contained a forbidden string."),
    SUCCESS("S", "Success", "The input meets all of the requirements."),
    FAILURE("F", "Failure", "The input dooes not meet one or more requirements.");

    private final String code;
    private final String description;
    private final String feedback;

    private Feedback(String code, String feedback, String description) {
        this.code = code;
        this.feedback = feedback;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }

}
