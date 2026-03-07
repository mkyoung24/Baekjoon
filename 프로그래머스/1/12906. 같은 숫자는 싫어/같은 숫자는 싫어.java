import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> s = new Stack<Integer>();
        
        s.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != s.peek()) {
                s.push(arr[i]);
            }
        }
        
        answer = new int[s.size()];
        
        while(!s.isEmpty()) {
            for (int j = answer.length - 1; j >= 0; j--) {
                answer[j] = s.pop();
            }
        }
        
        return answer;
    }
}