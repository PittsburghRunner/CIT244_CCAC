package utils.sorting;

import java.math.BigInteger;

/**
 * This utility contains a few methods that can be used to sort numbers
 *
 * @author christopher.eckles
 */
public class SortUtility {

    private boolean debug = false;
    int cycles = 0;
    int calculations = 0;
    int swaps = 0;
    int offset = 0;
    Boolean swapped = true;

    /**
     * Sorts an array of ints in ascending order.
     *
     * @param array
     * @return an array of sorted ints
     */
    public int[] sort(int[] array) {
        while (swapped == true) {
            cycles++;
            swapped = false;
            for (int i = 0; i < array.length - 1 - offset; i++) {
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
            offset++;
        }
        if (debug) {
            System.out.println("Total Cycles: " + cycles + "  Calculations: " + calculations + "  Swaps: " + swaps);
        }
        return array;
    }

    public void mergeSort(int[] list) {

        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            merge(firstHalf, secondHalf, list);
            //runs "on the folding back up"
        } //close if
    } //close merge sort

    public static void merge(int[] list1, int[] list2, int temp[]) {
        int current1 = 0;  //current index in list 1
        int current2 = 0;  //current index in list 2
        int current3 = 0;  //current index in temp list

        while (current1 < list1.length && current2 < list2.length) {
            if(list1[current1] < list2[current2]){
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list1[current2++];
            }
            
            while(current1 < list1.length){
                temp[current3++] = list1[current1++];
            }
            while(current2 < list2.length){
                temp[current3++] = list1[current2++];
            }
            
        } //close merge
    } //close merge
            public static BigInteger[] sortNumbers(BigInteger[] array) {
                Boolean swapped = true;
                while (swapped == true) {
                    swapped = false;
                    for (int i = 0; i < array.length - 1; i++) {
                        BigInteger first = array[i];
                        BigInteger second = array[i + 1];
                        if (first.compareTo(second) > 0) {
                            array[i] = second;
                            array[i + 1] = first;
                            swapped = true;
                        }
                    }
                }
                return array;
            }
    public Object[] sort(Comparable[] array) {
        while (swapped == true) {
            cycles++;
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                calculations++;
                Comparable first = array[i];
                Comparable second = array[i + 1];
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
