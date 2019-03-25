/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.lits.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import timeline.utils.lits.ListType;

/**
 *
 * @author ceckles
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PromptParams{

    public String name() default "";
    public int min() default 0;
    public int max() default 100;
    public String replacements() default "";
    public String listOfValues() default "";
    public ListType listType() default ListType.DEFAULT;
    public boolean hidden() default false;
    
}

