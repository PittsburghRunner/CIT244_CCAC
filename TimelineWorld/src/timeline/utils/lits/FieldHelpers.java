/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.utils.lits;

import utils.lits.input.Prompt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import timeline.TimelineWorld;
import utils.lits.input.PromptParams;

/**
 *
 * @author ceckles
 */
public class FieldHelpers {

    public static ArrayList<Prompt> retrieveClassFieldsForPrompting(Class c) {
        ArrayList<Prompt> prompts = new ArrayList<>();
        int order = 1;
        while (c != Object.class) {
            Field[] fields = c.getDeclaredFields();
            fieldLoop:
            for (Field field : fields) {
                String prompt = "PromptParam Annotation Not Found For " + field.getName();
                int min = 0;
                int max = 0;
                HashMap list = new HashMap<>();
                ListType listType = ListType.DEFAULT;
                Annotation[] annotationLst = field.getAnnotations();
                for (Annotation a : annotationLst) {
                    if (a instanceof PromptParams) {
                        PromptParams pp = (PromptParams) a;
                        if(pp.hidden()){
                            continue fieldLoop;
                        }
                        min = pp.min();
                        max = pp.max();
                        listType = pp.listType();
                        prompt = pp.listType().prompt.replace("%name", pp.name());
                        HashMap<String, Object> replacements = splitStringToMap(pp.replacements());
                        replacements.put("min", pp.min());
                        replacements.put("max", pp.max());
                        prompt = replaceUsingHashmap(prompt, replacements);
                        list = splitStringToMap(pp.listOfValues());
                    }
                }
                Prompt p;
                p = new Prompt(order, prompt, field, min, max, list, listType);
                prompts.add(p);
            }
            c = c.getSuperclass();
            order++;
        }
        Collections.sort(prompts);
        return prompts;
    }

    public static HashMap splitStringToMap(String s) {
        HashMap<String, String> map = new HashMap<>();
        if (s != null && !s.equals("")) {
            String[] splitString = s.split(",");
            for (String splitEntry : splitString) {
                String[] keyValue = splitEntry.split(":");
                map.put(keyValue[0], keyValue[1]);

            }
        }
        return map;
    }

    public static String replaceUsingHashmap(String string, HashMap<String, Object> hm) {
        for (Entry<String, Object> e : hm.entrySet()) {
            //System.out.println(e.getKey());
            String replace = "%" + e.getKey();
            String with = String.valueOf(e.getValue());
            string = string.replace(replace, with);
        }
        return string;
    }

    
   
}
