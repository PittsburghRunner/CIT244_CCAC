/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting.test;

import java.math.BigInteger;
import utils.sorting.SortUtility;

/**
 * Class to test the SortUtility
 *
 * @author christopher.eckles
 */
public class TestSortNumbers {

    public static void main(String[] args) {
        
        System.out.println("Creating a new sort utility");
        SortUtility su = new SortUtility();

        
        System.out.println("Turning on debugging");
        su.setDebug(true);
        
        System.out.println("FIRST TEST......");

        int[] sortInts = new int[]{67, 3345, 999999999, 0, 123, 123653633, 123, 35, 8888, 23, 2342, 222465, 1, 2, 3, 4, 5, 6, 1};
        printIntArray(sortInts);
        su.sortNumbers(sortInts);
        printIntArray(sortInts);

        System.out.println("NEXT TEST.....");
        BigInteger[] sortBigIntegers = {BigInteger.valueOf(23232), BigInteger.valueOf(1), BigInteger.valueOf(982342), BigInteger.valueOf(234343), BigInteger.valueOf(3), BigInteger.valueOf(2), BigInteger.valueOf(1), BigInteger.valueOf(9), BigInteger.valueOf(97)};
        printArray(sortBigIntegers);
        su.sortNumbers(sortBigIntegers);
        printArray(sortBigIntegers);

    }

    public static void printIntArray(int[] array) {
        System.out.print("Printing Array:   ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((array.length-1)==i?"\n\n\n":", "));
        }
    }

    public static void printArray(Object[] array) {
        System.out.print("Printing Array:   ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + ((array.length-1)==i?"\n\n\n":", "));
        }
    }
}
