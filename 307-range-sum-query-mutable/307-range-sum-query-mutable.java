// TO BE REDONE
public class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n << 1];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for (int i = n; i < n << 1; i++) {
            tree[i] = nums[i - n];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }

    void update(int i, int val) {
        for (tree[i += n] = val; i > 0; i >>= 1) {
            tree[i >> 1] = tree[i] + tree[i ^ 1];
        }
    }

    public int sumRange(int i, int j) {
        int ret = 0;
        for (i += n, j += n; i <= j; i >>= 1, j >>= 1) {
            if ((i & 1) == 1) ret += tree[i++];
            if ((j & 1) == 0) ret += tree[j--];
        }
        return ret;
    }
}