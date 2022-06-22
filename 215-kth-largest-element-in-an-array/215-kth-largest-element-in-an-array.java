class Solution {
    public int findKthLargest(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<FrequencyMap> heap = new PriorityQueue();
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            frequency.put(num, frequency.containsKey(num) ? frequency.get(num) + 1 : 1);
        }
        for(int num: frequency.keySet()){
            min = Math.min(min, num);
            if(num >= min){
                heap.add(new FrequencyMap(num, frequency.get(num)));
            }
        }
        int count = 0;
        while(!heap.isEmpty()){
            FrequencyMap top = heap.poll();
            if(count + top.freq >= k){
                return top.number;
            }
            count += top.freq;
        }
        return -1;
    }
}


class FrequencyMap implements Comparable<FrequencyMap> {
    int number;
    int freq;
    public FrequencyMap(int num, int freq){
        this.number = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(FrequencyMap o) {
        FrequencyMap newFM = (FrequencyMap) o;
        return newFM.number - this.number;

    }
}