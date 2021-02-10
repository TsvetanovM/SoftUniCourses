package marto.util.classes;

public class IntegerManipulation {

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : arr) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
