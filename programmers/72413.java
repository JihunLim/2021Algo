package programmers;
import java.util.*;

class Solution{
    /* 
        문제 : 합승 택시요금 (카카오 블라인드테스트 2021)
        링크 : https://programmers.co.kr/learn/courses/30/lessons/72413
        How  : FLOYD WARSHALL(플로이드 와샬) + BRUTE FORCE(완전탐색)
        https://www.youtube.com/watch?v=Xx5bk_EP8tQ&list=PL6YHvWRMtz7DhuPHdUZ0WLB5fNO729mbm&index=5
            * 플로이드 와샬 -> 다익스트라의 최단경로는 1차원상의 최단경로라면 플로이드 와샬은 2차원상의 최단경로라 보면 됨.
    */


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        
        // Init
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], 100_000_000); // 초기값으로 큰 값 설정(이론상 무한대)_int 범위를 벗어나면 안되니까    
            map[i][i] = 0; // 자기자신으로 가는 비용은 0으로 설정
        }

        for (int[] fare : fares)
            map[fare[0]][fare[1]] = map[fare[1]][fare[0]] = fare[2];
        
        // fluyd warshall 최단경로
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][k] + map[k][j] < map[i][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }





        return answer;
    }


}