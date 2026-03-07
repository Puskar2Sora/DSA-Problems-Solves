class Solution {
    static int noOfWays(int m, int n, int x) {
        
        int [][] k=new int[n+1][x+1];
        k[0][0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=x;j++)
            {
                for(int h=1;h<=m && h<=j;h++)
                {
                    k[i][j]+= k[i-1][j-h];
                }
            }
        }
        return k[n][x];
    }
};