package Baekjoon;

import java.util.Scanner;

public class N2468 {
    int n;
    int max = 0;
    int safe = 0;
    int count = 0;
    int[][] place;
    int[][] check;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N2468(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        place = new int[n][n];
        check = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                place[i][j] = sc.nextInt();
                max = Math.max(max, place[i][j]);
            }
        }

        for(int r = 0; r <= max; r++){
            count = 0;
            check = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(place[i][j] > r && check[i][j] == 0) {
                        count++;
                        DFS(r, j, i);
                    }
                }
            }
            safe = Math.max(count, safe);
        }

        System.out.println(safe);
    }

    public void DFS(int rain, int x, int y){
        check[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx >= 0 && my >= 0 && mx < n && my < n && check[my][mx] == 0 && place[my][mx] > rain){
                DFS(rain, mx, my);
            }
        }
    }
}
