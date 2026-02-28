class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        
        int i=0, j=arr2.length-1;
        int min=Integer.MAX_VALUE, a=0, b=0;
        
        ArrayList<Integer> r= new ArrayList<>();
        
        while(i<arr1.length && j>=0)
        {
            int s=arr1[i]+arr2[j], k=Math.abs(s-x);
            if(k<min)
            {
                min=k;
                a=arr1[i];
                b=arr2[j];
            }
            if(s==x) break;
            if(s>x) j--;
            else i++;
        }
        r.add(a);
        r.add(b);
        return r;
    }
}