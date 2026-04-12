class Solution {
    int countStrings(int n) {
        int a=1,b=1;
        for(int i=2;i<=n;i++)
        {
            int t=a;
            a=a+b;
            b=t;
        }
        return a+b;
    }
}
