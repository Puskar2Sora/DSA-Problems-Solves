import java.util.;
class Solution {
    public String findLargest(int[] arr) {
        
        String[] str = new String[arr.length];
        
        for(int i=0;iarr.length;i++)
            str[i]=String.valueOf(arr[i]);
    
        Arrays.sort(str,(a,b)-(b+a).compareTo(a+b));
        
        if(str[0].equals(0))
            return 0;
        
        StringBuilder re = new StringBuilder();
        for(String i  str)
           re.append(i);
           
        return re.toString();
    }
}