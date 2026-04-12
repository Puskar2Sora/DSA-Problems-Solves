import java.util.*;

class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        result.add("0");
        result.add("1");
        if (n == 1) return result;
        for (int i = 2; i <= n; i++) {
            int currentSize = result.size();
            for (int j = currentSize - 1; j >= 0; j--) 
                result.add("1" + result.get(j));
            for (int j = 0; j < currentSize; j++)
                result.set(j, "0" + result.get(j));
        }
        return result;
    }
}
