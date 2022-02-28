package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14502 {
    int n, m;
    int[][] map;
    int[][] vir;
    int count = 0;
    int max = Integer.MIN_VALUE;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public void N14502(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        vir = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) map[i][j] = sc.nextInt();
        }

        DFS(0);

        System.out.println(max);
    }

    public void safe(){
        // 안전 지역 0을 세는 부분
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vir[i][j] == 0) count++;
            }
        }
        max = Math.max(max, count);
        count = 0;
    }

    public void virus(){
        // 벽이 세개 세워지면 해당 배열을 클론하여 2를 3으로 감염시킴
        Queue<Point> q = new LinkedList<>();

        for(int h = 0; h < map.length; h++){ // 반복문 + ArrayCopy
            System.arraycopy(map[h], 0, vir[h], 0, vir[h].length);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) if(vir[i][j] == 2){
                vir[i][j] = 3;
                q.add(new Point(i, j));
            }
        }

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && ny < m && nx < n && vir[nx][ny] == 0){
                    vir[nx][ny] = 3;
                    q.add(new Point(nx, ny));
                }
            }
        }

        safe();
    }

    public void DFS(int l){
        if(l == 3){
            virus();
        }else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 0){
                        map[i][j] = 4;
                        DFS(l+1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
}
