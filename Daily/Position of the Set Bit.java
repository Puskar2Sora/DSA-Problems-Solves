class Solution {
    public int findPosition(int n) {
        int c=0;
        if (n<=0 || (n & (n - 1))!= 0)  return -1;
        while (n > 0) {
            n=n>>1; 
            c++;
        }
        return c;
    }
}
