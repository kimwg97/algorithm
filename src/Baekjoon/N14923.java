package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14923 {
    int n, m;
    Point s, e;
    int[][] map;
    int[][] copied;
    int[][] check;
    int min = Integer.MAX_VALUE;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N14923(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        copied = new int[n][m];
        s = new Point(sc.nextInt()-1, sc.nextInt()-1);
        e = new Point(sc.nextInt()-1, sc.nextInt()-1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    BFS();
                    map[i][j] = 1;
                }
            }
        }

        if(min != Integer.MAX_VALUE) System.out.println(min);
        else System.out.println(-1);

    }

    public void CopyMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) copied[i][j] = map[i][j];
        }
    }

    public void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(s);
        check = new int[n][m];

        CopyMap();

        while (!q.isEmpty()){
            Point temp = q.poll();

            if(check[temp.x][temp.y] > min) return;
            if(temp.x == e.x && temp.y == e.y) {
                min = check[e.x][e.y];
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && copied[nx][ny] == 0){
                    copied[nx][ny] = 1;
                    check[nx][ny] = check[temp.x][temp.y] + 1;
                    q.add(new Point(nx, ny));
                }

            }
        }
    }


}
