package utils.sorting;

import java.math.BigInteger;

/**
 * This utility contains a few methods that can be used to sort numbers
 *
 * @author christopher.eckles
 */
public class SortUtility {

    private boolean debug = false;

    /**
     * Sorts an array of ints in ascending order.
     *
     * @param array
     * @return an array of sorted ints
     */
    public int[] sortNumbers(int[] array) {
        int cycles = 0;
        int calculations = 0;
        int swaps = 0;
        Boolean swapped = true;
        while (swapped == true) {
            cycles++;
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                calculations++;
                int first = array[i];
                int second = array[i + 1];
                if (first > second) {
                    array[i] = second;
                    array[i + 1] = first;
                    swaps++;
                    swapped = true;
                    if (debug) {
                        System.out.println(cycles + ":" + calculations + ":" + swaps + ": Swapping " + second + " for " + first);
                    }
                }
            }
        }
        if (debug) {
            System.out.println("Total Cycles: " + cycles + "  Calculations: " + calculations + "  Swaps: " + swaps);
        }
        return array;
    }

//    public static BigInteger[] sortNumbers(BigInteger[] array) {
//        Boolean swapped = true;
//        while (swapped == true) {
//            swapped = false;
//            for (int i = 0; i < array.length - 1; i++) {
//                BigInteger first = array[i];
//                BigInteger second = array[i + 1];
//                if (first.compareTo(second) > 0) {
//                    array[i] = second;
//                    array[i + 1] = first;
//                    swapped = true;
//                }
//            }
//        }
//        return array;
//    }
    public Object[] sortNumbers(Comparable[] array) {
        int cycles = 0;
        int calculations = 0;
        int swaps = 0;
        Boolean swapped = true;
        while (swapped == true) {
            cycles++;
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                calculations++;
                Comparable first = (Comparable) array[i];
                Comparable second = (Comparable) array[i + 1];
                if (first.compareTo(second) > 0) {
                    array[i] = second;
                    array[i + 1] = first;
                    swaps++;
                    swapped = true;
                    if (debug) {
                        System.out.println(cycles + ":" + calculations + ":" + swaps + ": Swapping " + second + " for " + first);
                    }
                }
            }
        }
        if (debug) {
            System.out.println("Total Cycles: " + cycles + "  Calculations: " + calculations + "  Swaps: " + swaps);
        }
        return array;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    
}
