package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N10026 {
    int n;
    char[][] map;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N10026(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new char[n][n];

        for(int i = 0; i < n; i++){
            String x = sc.next();
            for(int j = 0; j < n; j++){
                map[i][j] = x.charAt(j);
            }
        }

        int count = 0;
        int wCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != '.'){
                    if(map[i][j] != 'A') wCount++;
                    BFS(map[i][j], i, j);
                    count++;
                }
            }
        }

        System.out.println(count + " " + wCount);
    }

    public void BFS(char color, int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        map[x][y] = '.';

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(map[nx][ny] == color){
                        map[nx][ny] = '.';
                        q.add(new Point(nx, ny));
                    }
                    else if(color == 'R' || color == 'G'){
                        if(map[nx][ny] == 'R' || map[nx][ny] == 'G'){
                            map[nx][ny] = 'A';
                            q.add(new Point(nx, ny));
                        }
                    }

                }
            }
        }

    }
}
