//1431. Kids With the Greatest Number of Candies


class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length,maxcandies=Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(candies[i]>maxcandies){
                maxcandies=candies[i];
            }
        }
        for(int i=0;i<n;i++){
            if(candies[i]+extraCandies>=maxcandies){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}
