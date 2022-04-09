class Solution {
    public int[] topKFrequent(int[] nums, int k) {    
        int[] result = new int[k];
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<NumFreq> heap = new PriorityQueue<>(new Comparator<NumFreq>(){
            @Override
            public int compare(NumFreq n1, NumFreq n2){
                if(n1.freq < n2.freq){
                    return -1;
                }
                return 1;
            }
        });

        for (int num: freq.keySet()) {
            int frequency = freq.get(num);
            if(heap.size() < k){
                heap.add(new NumFreq(num, frequency));
            }else if(heap.peek().freq < frequency){
                heap.poll();
                heap.add(new NumFreq(num, frequency));
            }
        }
        int idx = 0;
        while (!heap.isEmpty()) {
            result[idx++] = heap.poll().num;
        }
        
        return result;
    }
}


class NumFreq{
    int num;
    int freq;
    public NumFreq(int _num, int _freq){
        num = _num;
        freq = _freq;
    }
}