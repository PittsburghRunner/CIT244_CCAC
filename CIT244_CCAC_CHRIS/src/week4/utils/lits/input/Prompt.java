/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.utils.lits.input;

import java.lang.reflect.Method;
import java.util.HashMap;
import week4.utils.lits.ListType;

/**
 *
 * @author ceckles
 */
public class Prompt {
    String prompt;
    Method method;
    ListType listType;
    HashMap<String,String> list;
    
 public Prompt(String p, Method m, HashMap<String,String> l, ListType lt){
      prompt = p;
      method = m;
      list = l;
      listType = lt;

  }

    public String getPrompt() {
        return prompt;
    }

    public Method getMethod() {
        return method;
    }

    public ListType getListType() {
        return listType;
    }

    public HashMap<String, String> getList() {
        return list;
    }



  
}
