package programmers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /* 
           문제 : 완주하지 못한 선수
           링크 : https://programmers.co.kr/learn/courses/30/lessons/42576 
        */
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String str : participant) hm.put(str, hm.getOrDefault(str, 0)+1);
        for(String str : completion) hm.put(str, hm.get(str)-1);

        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            answer = entry.getKey();
            if(entry.getValue() > 0) break;
        }
        
        return answer;
    }

}