class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<IndexSoldierPair> heap = new PriorityQueue<>(k);
        int[] toReturn = new int[k];
        int columnSize = mat[0].length;
        int rowSize = mat.length;

        for (int i = 0; i < rowSize; i++) {
            int soldierCount = 0;
            for (int j = 0; j < columnSize; j++) {
                soldierCount += mat[i][j];
            }
            
            IndexSoldierPair currentRow = new IndexSoldierPair(i, soldierCount);
            if (heap.size() < k) {
                heap.add(currentRow);
            }else if(heap.peek().soldier > currentRow.soldier) {
                heap.poll();
                heap.add(currentRow);
            }
        }

        for (int i = 0; i < k; i++) {
            toReturn[k-1-i] = heap.poll().index;
        }
        
        return toReturn;
    }
    
}

class IndexSoldierPair implements Comparable {
    int index, soldier;

    public IndexSoldierPair(int i, int s) {
        index = i;
        soldier = s;
    }

    @Override
    public int compareTo(Object o) {
        if (this.soldier < ((IndexSoldierPair) o).soldier) return 1;
        if(this.soldier == (((IndexSoldierPair) o).soldier)) {
            if (this.index < ((IndexSoldierPair) o).index) return 1;
        }
        return -1;
    }
}