package Baekjoon;

import java.util.Scanner;

public class N1520 {

    int n, m;
    int[][] map;
    int[][] dp;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public void N1520(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }

    public int DFS(int x, int y) {
        if (x == n - 1 && y == m - 1) return 1;

        if (dp[x][y] != -1) return dp[x][y];
        else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[x][y] > map[nx][ny]) {
                    dp[x][y] += DFS(nx, ny);
                }
            }
        }

        return dp[x][y];
    }


}
