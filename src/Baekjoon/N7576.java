package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7576 {
    int n, m;
    int[][] map;
    ArrayList<Point> ripedTomato = new ArrayList<>();

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    int count = 0;

    public void N7576(){
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n][m];

        boolean flag = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0) flag = true;
                else if(map[i][j] == 1) ripedTomato.add(new Point(i, j));
            }
        }

        if(!flag) System.out.println(0);
        else{

            tomato();

            flag = true;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) flag = false;
                }
            }

            if(flag) System.out.println(count-1);
            else System.out.println(-1);
        }

    }

    public void tomato(){
        Queue<Point> q = new LinkedList<>();

        for(Point t : ripedTomato) q.add(t);

        while (!q.isEmpty()) {
            int l = q.size();

//            System.out.println(count);
//            for(int k = 0; k < n; k++){
//                for(int h = 0; h < m; h++){
//                    System.out.print(map[k][h] + " ");
//                }
//                System.out.println();
//            }

            for (int j = 0; j < l; j++) {
                Point temp = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            count++;
        }
    }
}
