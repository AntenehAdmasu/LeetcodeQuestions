// TO BE REDONE
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>(); 
        deque.offer(0);
        for (int i = 1; i < n; ++i) {
            int firstIndex = deque.peekFirst();
            int firstValue = nums[firstIndex];
            nums[i] = firstValue + nums[i];

            while (!deque.isEmpty()) {
                int lastIndex = deque.peekLast();
                int lastValue = nums[lastIndex];
                int currentValue = nums[i];
                if ((lastValue > currentValue))
                    break;
                deque.pollLast();
            }
            deque.offerLast(i);

            int differenceFromFirstIndex = i - deque.peekFirst();
            if (differenceFromFirstIndex >= k)
                deque.pollFirst();
        }
        return nums[n - 1];
    }
}