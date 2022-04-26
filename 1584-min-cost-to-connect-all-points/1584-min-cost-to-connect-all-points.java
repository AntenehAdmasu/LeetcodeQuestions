// To be redone
class Solution {
     public int minCostConnectPoints(int[][] points) {          
         Queue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[2]-b[2]);      
         for(int i=0;i<points.length;i++){
             for(int j=i+1;j<points.length;j++){               
                 int d = getDistance(points[i], points[j]);
                 queue.add(new int[]{i,j, d});              
             }
         }

         int N = points.length;      
         UFD ufd = new UFD(N);      
         int count = N-1;      
         int cost = 0;      
         while(queue.size()> 0 && count > 0){
            int[] edge = queue.poll();          
             if(!ufd.isConnected(edge[0], edge[1])){
                 ufd.union(edge[0], edge[1]);
                 cost += edge[2];
                 count--;
             }
         }      
         return cost;      
     }
    
    
     public int getDistance(int[] p1, int[] p2){
         return Math.abs( p2[0] - p1[0]) + Math.abs(p2[1] - p1[1] );
     }
 }

 public class UFD{
     int[] parents;
     int[] ranks;  
     
     public UFD(int size){
         this.parents = new int[size];
         this.ranks = new int[size];
         for(int i=0;i<size;i++){
             parents[i] = i;
             ranks[i] = 1;
         }
     }    
     
     public int find(int x){
         if(x == parents[x]){
             return x;
         }      
         parents[x] = find(parents[x]);      
         return  parents[x];      
     }  
     
     public void union(int x, int y){
         int a = find(x);
         int b = find(y);
         if(a!=b){
            if(ranks[a] > ranks[b]){
                parents[b] = a;
            }else if(ranks[b] > ranks[a]){
                parents[a] = b;
            }else{
                parents[a] = b;
                ranks[b]++;
            }
         }
         return;
     }
     public boolean isConnected(int x, int y){
         return find(x) == find(y);
     }   
 }