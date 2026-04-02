class Solution {
    int countWays(int n, int k) {
        if (n==0) return 0;
        if (n==1) return k;
        if (n==2) return k * k;
        int a=k;      
        int b=k*k;  
        int c=0;
        for (int i=3;i<=n;i++) {
            c=(a+b)*(k - 1);
            a=b;
            b=c;
        }
        return b;
    }
}
