class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,m=0;
        while(l<r)
        {
            int w=r-l;
            int c=Math.min(height[l],height[r]);
            int k=w*c;
            m=Math.max(k,m);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return m;
    }
}