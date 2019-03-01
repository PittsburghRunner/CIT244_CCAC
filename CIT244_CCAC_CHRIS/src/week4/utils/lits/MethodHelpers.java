/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.utils.lits;

import week4.utils.lits.input.Prompt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import week4.utils.lits.input.PromptParams;

/**
 *
 * @author ceckles
 */
public class MethodHelpers {

    public static ArrayList<Prompt> retrieveClassMethodsForPrompting(Object o) {
        ArrayList<Prompt> prompts = new ArrayList<>();
        Class c = o.getClass();
        c.getDeclaredMethods();

        for (Method m : c.getDeclaredMethods()) {
            if (m.getName().startsWith("set")) {
                String prompt = "Annotation Not Found";
                HashMap<String, String> list = new HashMap<>();
                ListType listType = ListType.DEFAULT;
                Annotation[] annotationLst = m.getAnnotations();
                for (Annotation a : annotationLst) {
                    if (a.annotationType().equals(PromptParams.class)) {
                        PromptParams pp = (PromptParams) a;
                        prompt = pp.listType().prompt.replaceAll("%name",pp.name());
                        prompt = replaceUsingHashmap(prompt,splitStringToMap(pp.replacements()));
                        list = splitStringToMap(pp.listOfValues());
                        if (list.isEmpty()) {
                            if (!pp.min().isEmpty()) {
                                list.put("MIN", pp.min());
                            }
                            if (!pp.max().isEmpty()) {
                                list.put("MIN", pp.max());
                            }
                        }
                    }
                }

                Prompt p;
                p = new Prompt(prompt, m, list, listType);
                prompts.add(p);
            }
        }
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
    
    public static String replaceUsingHashmap(String string, HashMap<String,String> hm){
        for(Entry e:hm.entrySet()){
           String replace = "%"+(String)e.getKey();
           String with = (String) e.getValue();
           string = string.replaceAll(replace, with);
        }
        return string;
    }
}
