package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N10026 {
    int n;
    char[][] map;
    char[][] RGWMap;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N10026(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new char[n][n];
        RGWMap = new char[n][n];

        for(int i = 0; i < n; i++){
            String x = sc.next();
            for(int j = 0; j < n; j++){
                map[i][j] = x.charAt(j);
                RGWMap[i][j] = x.charAt(j);
                if(RGWMap[i][j] == 'G') RGWMap[i][j] = 'R';
            }
        }
        int count = 0;
        int wCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != '.'){
                    char color = map[i][j];
                    map[i][j] = '.';
                    rDFS(i, j, color);
                    count++;
                }
                if(RGWMap[i][j] != '.'){
                    char color = RGWMap[i][j];
                    RGWMap[i][j] = '.';
                    wDFS(i, j, color);
                    wCount++;
                }
            }
        }

        System.out.println(count + " " + wCount);
    }

    public void rDFS(int x, int y, char color){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == color){
                map[nx][ny] = '.';
                rDFS(nx, ny, color);
            }
        }
    }

    public void wDFS(int x, int y, char color){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && RGWMap[nx][ny] == color){
                RGWMap[nx][ny] = '.';
                wDFS(nx, ny, color);
            }
        }
    }
}
