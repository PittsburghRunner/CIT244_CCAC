/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.utils.lits.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import week4.utils.lits.ListType;

/**
 *
 * @author ceckles
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)


public @interface PromptParams {

    public String name() default "";
    public String min() default "";
    public String max() default "";
    public String replacements() default "";
    public String listOfValues() default "";
    public ListType listType() default ListType.DEFAULT;


}