package Baekjoon;

import java.util.Scanner;

public class N1012 {

    int n, m, b, count;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    int[][] map;

    public void N1012(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int k = 0; k < t; k++){
            m = sc.nextInt();
            n = sc.nextInt();
            b = sc.nextInt();

            map = new int[n][m];
            count = 0;

            for(int i = 0; i < b; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                map[b][a] = 1;
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1){
                        map[i][j] = 0;
                        DFS(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public void DFS(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1){
                map[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
}
