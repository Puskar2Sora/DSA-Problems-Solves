class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> rm = new ArrayList<>(); 
        int k=Arrays.stream(candies).max().getAsInt();
        for(int i=0;i<candies.length;i++)
        {
            int m=candies[i]+extraCandies;
            rm.add(m>=k);              
        }
        return rm;
    }
}