class TimeMap {

    Map<String, TreeMap<Integer, String>> map = null;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        /*
        if(map.get(key) != null){
            TreeMap<Integer, String> interMap = map.get(key);
            interMap.put(timestamp, value);
        }else{
            TreeMap<Integer, String> interMap = new TreeMap<>(Collections.reverseOrder());
            interMap.put(timestamp,value);
            map.put(key,interMap);
        }
        */

        map.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp,value);

    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap == null) return "";
        
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();

        /*
        if(map.get(key).get(timestamp) != null) return map.get(key).get(timestamp);
        else{
            TreeMap<Integer, String> interMap = map.get(key);
            for(Integer timestamp_prev : interMap.keySet()){
                if(timestamp > timestamp_prev) return interMap.get(timestamp_prev);
            }
        }
        */ 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */