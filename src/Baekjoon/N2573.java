package Baekjoon;

import java.util.Scanner;

public class N2573 {

    int n, m;
    int[][] map;
    int[][] copy;
    int count = 0;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N2573(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int c = 0;
        copy = new int[n][m];

        while (c < 2){
            c = 0;
            if(melt() == 0) {
                count = 0;
                break;
            }

            copyMap();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(copy[i][j] != 0){
                        copy[i][j] = 0;
                        DFS(i, j);
                        c++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public void copyMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copy[i][j] = map[i][j];
            }
        }
    }

    public int melt(){
        count++;
        boolean check = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 0){
                    map[i][j]--;
                    check = true;
                }
            }
        }

        if(check) return 1;
        else return 0;
    }

    public void DFS(int x, int y){
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && copy[nx][ny] != 0) {
                copy[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

}
