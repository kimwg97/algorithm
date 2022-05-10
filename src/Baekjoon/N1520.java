package Baekjoon;

import java.util.Scanner;

public class N1520 {

    int n, m;
    int[][] map;
    int[][] dp;
    int count = 0;

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

        int start = map[0][0];
        map[0][0] = 10001;

        DFS(0, 0, start);

        System.out.println(count);

    }

    public void DFS(int x, int y, int high){
        if(x == n-1 && y == m-1){
            count++;
            return;
        }else {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if(nx >= 0 && ny >=0 && nx < n && ny < m && high > map[nx][ny]){
                    int next = map[nx][ny];
                    map[nx][ny] = 10001;
                    DFS(nx, ny, next);
                    map[nx][ny] = next;
                }
            }
        }
    }

}
