package programmers;

import java.util.*;

class Solution {
    /* 
        문제 : 메뉴 리뉴얼 (카카오 블라인드테스트 2021)
        링크 : https://programmers.co.kr/learn/courses/30/lessons/72411
        How  : 해쉬(Map, PriorityQueue) + 정렬(sort) + DFS(깊이탐색)
    */

    // 전역변수
    static HashMap<String, Integer> map;
    static int m;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            m=0;
            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
                
            }
            for (String s : map.keySet()){
                if(map.get(s)==m && m>1){
                    pq.offer(s);
                }
            }
        }
        
        String ans[] = new String[pq.size()];
        int k=0;
        while(!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        
        return ans;
    }

    private void find(int cnt, String str, int tgNum, int idx, String word) {
        if(cnt == tgNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps = "";
            for (int i = 0; i < c.length; i++) temps += c[i];
            map.put(temps, map.getOrDefault(temps,0)+1);
            m = Math.max(m, map.get(temps));
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(cnt+1, str+now, tgNum, i+1, word);
        }

    }


}
