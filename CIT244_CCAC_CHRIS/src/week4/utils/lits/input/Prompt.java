/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.utils.lits.input;

import java.lang.reflect.Field;
import java.util.HashMap;
import week4.utils.lits.ListType;

/**
 *
 * @author ceckles
 */
public class Prompt {
    int min;
    int max;
    String prompt;
    Field field;
    ListType listType;
    HashMap<String,String> list;
    
 public Prompt(String p, Field f, int min, int max, HashMap<String,String> l, ListType lt){
      prompt = p;
      field = f;
      list = l;
      listType = lt;

  }

    public String getPrompt() {
        return prompt;
    }

    public Field getField() {
        return field;
    }

    public ListType getListType() {
        return listType;
    }

    public HashMap<String, String> getList() {
        return list;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    
    



  
}
