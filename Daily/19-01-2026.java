class Solution {
    public String removeKdig(String s, int k) {
        // code here
        if(k>= s.length())
           return "0";
        
        StringBuilder stack=new StringBuilder();
       
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            while(stack.length()>0 && k>0 && stack.charAt(stack.length() - 1) > c)
            {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
       
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        int m=0;
       
        while(m<stack.length() && stack.charAt(m)=='0')
             m++;
        
        String an = stack.substring(m);
        return an.length() == 0 ? "0" : an;
        
    }
}