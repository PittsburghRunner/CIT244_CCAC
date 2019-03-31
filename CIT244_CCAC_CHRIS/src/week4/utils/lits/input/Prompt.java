/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.utils.lits.input;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import week4.timeline.utils.lits.ListType;

/**
 *
 * @author ceckles
 */
public class Prompt implements Comparable {

    int order;
    int min;
    int max;
    String prompt;
    Field field;
    ListType listType;
    HashMap<String, String> list;

    public Prompt(int o, String p, Field f, int mn, int mx, HashMap<String, String> l, ListType lt) {
        order = o;
        prompt = p;
        field = f;
        min = mn;
        max = mx;
        list = l;
        listType = lt;

    }

    public int getOrder() {
        return order;
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

    @Override
    public int compareTo(Object o) {
        if (o instanceof Prompt) {
            Prompt p = (Prompt) o;
            if (this.getOrder() > p.getOrder()) {
                return -1;
            } else if (this.getOrder() < p.getOrder()) {
                return 1;
            }
        }
        return 0;
    }
}
