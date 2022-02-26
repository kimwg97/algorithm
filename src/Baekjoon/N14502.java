package Baekjoon;

import java.util.Scanner;

public class N14502 {
    int n, m;
    int[][] map;
    boolean[][] check;

    public void N14502(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) map[i][j] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    check = new boolean[n][m];
                    DFS(i, j);
                }
            }
        }

    }

    public void virus(){

    }

    // 위에서 for 문으로 DFS 호출
    // 벽은 무조건 세개 세워야 하므로 먼저 세개 세우고
    // 세개 다 세웠으면 2로 채우고(다른 함수)
    // 0개수 세고
    // 백트래킹 하면서 다른 곳에 벽을 세워가면서 반복
    public void DFS(int x, int y){

    }
}
