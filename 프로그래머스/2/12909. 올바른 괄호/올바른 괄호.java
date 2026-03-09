import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

       Queue<Character> q = new ArrayDeque<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                q.offer('(');
            } else {
                if (q.size() > 0) {
                    q.poll();
                } else {
                    answer = false;
                    return answer;
                }
            }
        }
            
        if (q.size() == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}