class Solution {
    public String largestSwap(String s) {
        
        char[] m=s.toCharArray();
        int[] k=new int[10];
        for(int i=0;i<m.length;i++)
           k[m[i]-'0']=i;
        for(int i=0;i<m.length;i++)
        {
            int d=m[i]-'0';
            for(int j=9;j>d;j--)
            {
                if(k[j]>i)
                {
                    char t=m[i];
                    m[i]=m[k[j]];
                    m[k[j]]=t;
                    return new String(m);
                }
            }
        }
        return s;
    }
}