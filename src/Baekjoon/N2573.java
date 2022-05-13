package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
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

        while (true){
            c = 0;

            System.out.println();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
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

            if(c > 1 ) break;

            if(melt() == 0) {
                count = 0;
                break;
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
        Queue<Point> q = new LinkedList<>();
        boolean zero = true;
        boolean[][] check = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 0){
                    q.add(new Point(i, j));
                    check[i][j] = true;
                    zero = false;
                }
            }
        }

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0 && check[nx][ny] == false) {
                    if(map[temp.x][temp.y] > 0 ) map[temp.x][temp.y]--;
                }
            }
        }

        if(zero) return 0;
        else return 1;
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
