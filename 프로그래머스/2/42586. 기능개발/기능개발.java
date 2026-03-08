import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        Stack<Integer> ans = new Stack<Integer>();
        
        for (int i = 0; i < progresses.length; i++) {
            int pro = progresses[i];
            int spe = speeds[i];
            int count = 0;
            
            if ((100 - pro) % spe > 0) {
                count = ((100 - pro) / spe) + 1;
            } else {
                count = (100 - pro) / spe;
            }
            
            q.add(count);
            
        }
    
        
        int check = 0;
        int count = 0;
        
        while(!q.isEmpty()) {
            int n = q.poll();
            
            if (n > check) {
                count = 1;
                ans.push(count);
                check = n;
            } else {
                int num = ans.pop();
                num++;
                ans.push(num);
            }
            
        }
        
        answer = new int[ans.size()];
        
        while(!ans.isEmpty()) {
            for (int i = answer.length - 1; i >= 0; i--) {
                answer[i] = ans.pop();
            }
        }
        
        return answer;
    }
}