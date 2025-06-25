import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0 ; i < clothes.length ; i++){
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
            System.out.println(map);
        }

        int answer = 1;

        for(Entry<String, Integer> entry : map.entrySet()){
            System.out.println("enrty: " + entry);
            answer *= entry.getValue() + 1;
        }

        return answer -1;
    }
}