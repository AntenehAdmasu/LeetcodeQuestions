class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int index = 0;
        int total = 0;
        while(truckSize > 0 && index < boxTypes.length){
            int[] box = boxTypes[index++];
            int boxesTaken = Math.min(truckSize, box[0]);
            total += boxesTaken * box[1];
            truckSize -= boxesTaken;
        }
        return total;
    }
}