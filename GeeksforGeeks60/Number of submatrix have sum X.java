class Solution {
    public int countSquare(int[][] mat, int x) {
       
        int n=mat.length, m=mat[0].length, c=0,k;
       
       int[][] pr=new int[n+1][m+1];
       
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
                pr[i][j]= mat[i-1][j-1]+pr[i-1][j]+pr[i][j-1]-pr[i-1][j-1];
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                for(int h=1; i+h<=n && j+h<=m; h++)
                {
                    int r1=i, c1=j, r2=i+h-1, c2=j+h-1;
                    long s=pr[r2+1][c2+1]-pr[r1][c2+1]-pr[r2+1][c1]+pr[r1][c1];
                    if(s==x) c++;
                }
            }
        }
        return c;
    }
}