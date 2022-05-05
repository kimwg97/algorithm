package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N16236 {

    public class Shark{
        int x;
        int y;
        int size;
        int feed;

        public Shark(int x, int y, int size, int feed){
            this.x = x;
            this.y = y;
            this.size = size;
            this.feed = feed;
        }
    }

    int n;
    int[][] map;
    int[][] feedMap;
    Shark shark;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};


    public void N16236(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        feedMap = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) shark = new Shark(i, j, 2, 0);
            }
        }

        int help = 0;

        while (true) {
            int move = feeding();
            if(move == 0) break;
            else help += move;
            System.out.println(help);
        }

        System.out.println(help);
    }

    public int feeding(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(shark.x, shark.y));
        int count = 0;

        copyMap();
        feedMap[shark.x][shark.y] = -1;

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(feedMap[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(feedMap[nx][ny] == 0){
                        feedMap[nx][ny] = -1;
                        q.add(new Point(nx, ny));
                    }
                    else if(shark.size == feedMap[nx][ny]){
                        q.add(new Point(nx, ny));
                    }
                    else if(shark.size > feedMap[nx][ny] && feedMap[nx][ny] != -1){
                        map[nx][ny] = 0;
                        shark.feed += 1;
                        if(shark.feed == shark.size){
                            shark.size++;
                            shark.feed = 0;
                            shark.x = nx;
                            shark.y = ny;
                        }
                        return count;
                    }
                }
            }
        }

        return 0;
    }

    public void copyMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                feedMap[i][j] = map[i][j];
            }
        }
    }
}
