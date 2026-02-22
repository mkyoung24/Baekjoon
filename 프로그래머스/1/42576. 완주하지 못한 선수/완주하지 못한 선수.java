import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> part = new HashMap<>();
        for (String arg : participant) {
            boolean contains = part.containsKey(arg);
            if (contains) {
                part.put(arg, part.get(arg) + 1);
            } else {
                part.put(arg, 1);
            }
        }
        
        for (String arg : completion) {
            boolean contains = part.containsKey(arg);
            if (contains) {
                part.put(arg, part.get(arg) - 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : part.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}