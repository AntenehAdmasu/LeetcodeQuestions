class Solution {
    public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; 
    if(i >= 0) {                           
        int j = A.length - 1;              
        while(A[j] <= A[i]) j--;  
        swap(A, i, j);                     
    }
        
    i++;
    int n = A.length - 1;
    while(i < n) swap(A, i++, n--);
  
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    

}