class Solution {

    public int splitArray(int[] nums, int m) {
        
        // Low - the maximum element in the array (the minimum amount a partition can have)
        // High - the total sum (maximum amount, when m = 1)
        int low = 0,high = 0;

        for(int i: nums){
            low = Math.max(low, i);
            high += i;
        }

        while(low <= high){
            int mid = (low + high) / 2;
            if(isPossible(nums,m,mid)){ // paritiionable? with this limit?
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] nums,int m,int limit){

        int partitions = 1, sum = 0;

        for(int num: nums){
            sum += num;
            if(sum > limit){ // Start a new partition
                partitions++;
                sum = num;
                if(partitions > m){ // All numbers not included, increase limit
                    return false;
                }
            }
        }

        return true;

    }
}