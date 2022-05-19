package Baekjoon;

import java.util.Scanner;

public class N1937 {

    int n;
    int[][] map;
    int[][] dp;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N1937(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == 0) DFS(i, j);
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] > max) max = dp[i][j];
            }
        }

        System.out.println(max + 1);
    }

    public int DFS(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;


            if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] > map[x][y]){
                if(dp[nx][ny] == 0) {
                    int next = DFS(nx, ny);
                    if(next >= dp[x][y]) dp[x][y] = next + 1;
                }
                else if(dp[nx][ny] >= dp[x][y]) dp[x][y] = dp[nx][ny] + 1;
            }
        }

        return dp[x][y];
    }
}
