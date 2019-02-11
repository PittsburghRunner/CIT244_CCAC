/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting;


/**
 *
 * @author christopher.eckles
 */
public class SortIntegers {

    public static int[] sortIntegerArray(int[] intArray) {
        Boolean shifted = true;
        while (shifted == true) {
            shifted = false;
            for (int i = 0; i < intArray.length - 1; i++) {
                int first = intArray[i];
                int second = intArray[i + 1];
                if (first > second) {
                    intArray[i] = second;
                    intArray[i + 1] = first;
                    shifted = true;
                }
            }
        }
        return intArray;
    }
}
