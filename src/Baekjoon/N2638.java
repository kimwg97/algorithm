package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2638 {

    int n, m;
    int[][] map;
    boolean[][] visit;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    boolean check = true;

    public void N2638(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        map[0][0] = 2;

        while (check) {
            visit = new boolean[n][m];
            DFS(0, 0);
            BFS();
            count++;
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.println(count-1);

    }

    public void DFS(int x, int y){
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1 && visit[nx][ny] == false){
                map[nx][ny] = 2;
                DFS(nx, ny);
            }
        }
    }

    public void BFS(){
        Queue<Point> q = new LinkedList<>();

        int c = 0;
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    q.add(new Point(i, j));
                    visit[i][j] = true;
                    c++;
                }
            }
        }

        if(c == 0) check = false;

        while (!q.isEmpty()){
            Point temp = q.poll();
            int count = 0;

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 2 && visit[nx][ny] == false){
                    count++;
                    if(count == 2){
                        map[temp.x][temp.y] = 2;
                        break;
                    }
                }
            }

        }

    }

}
