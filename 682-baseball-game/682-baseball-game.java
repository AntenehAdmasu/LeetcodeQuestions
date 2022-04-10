class Solution {
    public int calPoints(String[] ops) {
        List<Integer> points = new ArrayList<>();
        int lastIndex = -1;
        int totalPoints = 0;
        for(String op: ops){
            if(op.equals("+")){
                points.add(points.get(lastIndex) + points.get(lastIndex-1));
            }else if(op.equals("D")){
                points.add(2*points.get(lastIndex));
            }else if(op.equals("C")){
                totalPoints -= points.get(lastIndex);
                points.remove(lastIndex);
                lastIndex--;
                continue;
            }else{
                points.add(Integer.parseInt(op));
            }
            lastIndex++;
            totalPoints += points.get(lastIndex);
        }
        
        return totalPoints;
    }
}