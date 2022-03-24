class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int totalTravels = 0;
        int right = people.length - 1;
        int left = 0;
        
        while(left <= right){
            int extra = limit - people[right];
            if(people[left] <= extra){
                left++;
            }
            totalTravels++;
            right--;
        }
        return totalTravels;
    }
}