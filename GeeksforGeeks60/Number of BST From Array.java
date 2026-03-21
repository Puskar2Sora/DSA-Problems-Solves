class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        int n=arr.length;
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        long[] c=new long[n+1];
        c[0]=1;
        c[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
             c[i] =c[i]+(c[j]*c[i-1-j]);
        }
        
        ArrayList<Integer> r = new ArrayList<>();
        for(int x:arr)
        {
            int in=Arrays.binarySearch(sorted,x);
            int L=in;
            int R=n-1-in;
            r.add((int)(c[L]*c[R]));
        }
        return r;
    }
}