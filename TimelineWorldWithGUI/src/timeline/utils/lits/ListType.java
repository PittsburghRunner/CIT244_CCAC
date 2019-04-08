/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.utils.lits;

import java.util.Date;

/**
 *
 * @author ceckles
 */
public enum ListType {
    DEFAULT("Default","Enter the %name: ",String.class),
    DATE("Date","Enter a %name date between years %min and %max\n(YYYY-MM-DD): ",Date.class),
    STRING_MIN_MAX("String with a minimum and maximum","Enter the %name between %min and %max characters: ",String.class),
    STRING_LIST_OF_VALUES("String from a list of values","Choose a %name out of the list above: ",Integer.class),
    INTEGER("Number","Enter a number for %name: ", Integer.class),
    DOUBLE("Number","Enter a number for %name: ", Double.class),
    INTEGER_LIST_OF_VALUES("Number from a list of values","Choose a %name out of the list above: ",Integer.class),
    INTEGER_MIN_MAX("Number with a minimum and maximum","Enter a number between %min and %max for the %name: ",Integer.class),
    BOOLEAN("Yes or No Input","%name? \n Y - Yes or N - No: ",Boolean.class);

    String identifier;
    String prompt;
    Class classType;
    
    ListType(String i, String p, Class t){
        identifier = i;
        prompt = p;
        classType = t;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPrompt() {
        return prompt;
    }

    public Class getClassType() {
        return classType;
    }
    
    
     
}
