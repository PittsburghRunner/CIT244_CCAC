/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting.test;

import utils.sorting.Sorter;

/**
 *
 * @author christopher.eckles
 */
public class SorterUnitTests {

    public static boolean runTest() {
        boolean testPassed = true;
        Sorter sorter = new Sorter();
        //unit test 1 -- bubble sort
        int[] given1 = new int[]{10, 6, 4, 1};
        int[] expected1 = new int[]{1, 4, 6, 10};

        sorter.bubbleSort(given1);
        if (!given1.equals(expected1)) {
            System.out.println("test 1 failed");

            return false;
        }

        //unit test 2 -- bucket sort
        int[] given2 = new int[]{6, 4, 1, 7, 3, 2};
        int[] expected2 = new int[]{1, 2, 3, 4, 5, 6};

        sorter.bubbleSort(given2);
        if (!given2.equals(expected2)) {
            System.out.println("test 2 failed");

            return false;
        }

        //unit test 3 -- bucket sort
        int[] given3 = new int[]{10, 6, 4, 1};
        int[] expected3 = new int[]{1, 4, 6, 10};

        sorter.bucketSort(given3);
        if (!given3.equals(expected3)) {
            System.out.println("test 3 failed");
            return false;
        }

        //unit test 4 -- bucket sort
        int[] given4 = new int[]{6, 4, 1, 7, 3, 2};
        int[] expected4 = new int[]{1, 2, 3, 4, 5, 6};

        sorter.bucketSort(given4);
        if (!given4.equals(expected4)) {
            System.out.println("test 4 failed");

            return false;
        };

        return testPassed;
    }

}
