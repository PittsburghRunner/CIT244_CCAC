/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting.test;

import utils.sorting.SortIntegers;

/**
 *
 * @author christopher.eckles
 */
public class TestSortIntegers {
    
    public static void main(String[] args) {
        int[] sortMe = new int[] {123,123653633,123,35,8888,23,2342,222465};
        
        printIntArray(sortMe);
       SortIntegers.sortIntegerArray(sortMe);
               printIntArray(sortMe);

    }
    
    
    public static void printIntArray(int[] intArray){
        System.out.println("Printing Array:");
        for(int i = 0 ; i < intArray.length ; i++ ){
            System.out.println(intArray[i]);
        }
    }
}
