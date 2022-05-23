package Baekjoon;

import java.util.Scanner;

public class N1926 {

    int n, m;
    int[][] picture;

    int size = 0;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N1926(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        picture = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                picture[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 1){
                    size = 1;
                    picture[i][j] = 0;
                    DFS(i, j);
                    max = Math.max(max, size);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public void DFS(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && picture[nx][ny] == 1){
                picture[nx][ny] = 0;
                size++;
                DFS(nx, ny);
            }
        }
    }
}
