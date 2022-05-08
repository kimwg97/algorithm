package Baekjoon;

import java.util.Scanner;

public class N4963 {

    int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};

    int n, m;
    int[][] map;
    int count = 0;

    public void N4963(){
        Scanner sc = new Scanner(System.in);
        while (true){
            count = 0;
            m = sc.nextInt();
            n = sc.nextInt();

            if(n == 0 && m == 0) break;

            map = new int[n][m];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1){
                        map[i][j] = 0;
                        count++;
                        DFS(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public void DFS(int x, int y){
        for(int i = 0; i < 8; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >=0 && nx < n && ny < m && map[nx][ny] == 1){
                map[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
}
