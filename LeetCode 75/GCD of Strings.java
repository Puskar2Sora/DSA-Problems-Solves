class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String k= str1.length()>str2.length() ? str1:str2;
        for(int i=k.length();i>0;i--)
        {
            String m=k.substring(0,i);
            if(div(str1,m) && div(str2,m))
             return m;
        }
        return "";
    }
    private boolean div(String i,String j)
    {
       if(i.length()%j.length()!=0) return false;
       StringBuilder sb =new StringBuilder();
       int r=i.length()/j.length();
       for(int l=0;l<r;l++) sb.append(j);
       return sb.toString().equals(i);
    }
}