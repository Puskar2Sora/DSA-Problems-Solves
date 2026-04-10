import java.util.*;
class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        if (n < 3) return result;
        int[] smaller = new int[n];
        int minIndex = 0;
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[minIndex]) {
                minIndex = i;
                smaller[i] = -1;
            } else
                smaller[i] = minIndex;
        }
        int[] greater = new int[n];
        int maxIndex = n - 1;
        greater[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
                greater[i] = -1;
            } else
                greater[i] = maxIndex;
        }
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                result.add(arr[smaller[i]]);
                result.add(arr[i]);
                result.add(arr[greater[i]]);
                return result;
            }
        }
        return result;
    }
}
