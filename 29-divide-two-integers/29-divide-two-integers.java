// TO BE REDONE
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean neg = (dividend < 0) ^ (divisor < 0);
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor);
        long result = 0;
        while (m >= n) {
            int shift = 0;
            while (m > (n << shift + 1)) {
                shift++;
            }
            m -= n << shift;
            result += (1 << shift);
        }
        result = (neg) ? ~(result - 1) : result;
        result = Math.min(Integer.MAX_VALUE, result);
        result = Math.max(Integer.MIN_VALUE, result);
        return (int)result;
    }
}