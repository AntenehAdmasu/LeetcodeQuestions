class UndergroundSystem {
    HashMap<Integer, String[]> checkInCheckOut;
    HashMap<String, int[]> average;

    public UndergroundSystem() {
        checkInCheckOut = new HashMap<>();
        average = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        String[] stationTime = new String[2];
        stationTime[0] = stationName;
        stationTime[1] = ""+t;
        checkInCheckOut.put(id, stationTime);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String[] entryStationTime = checkInCheckOut.get(id);
        String start = entryStationTime[0];
        String stationPair = start + "," + stationName;
        
        int entryTime = Integer.parseInt(entryStationTime[1]);
        int timeSpent = t - entryTime;
        int[] existing;
        
        if(average.containsKey(stationPair)){
            existing = average.get(stationPair);
            existing[0] += timeSpent;
            existing[1]++;
        }else{
            existing = new int[2];
            existing[0] = timeSpent;
            existing[1] = 1;
        }       
        average.put(stationPair, existing);                                 
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] totalOper = average.get(startStation + "," + endStation);
        double average = totalOper[0] / (1.0 * totalOper[1]);
        return average;
    }
}
                                         


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */