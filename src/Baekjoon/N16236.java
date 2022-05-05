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
    int dist;
    int[][] map;
    int[][] feedMap;
    Shark shark;
    Point minDist;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};


    public void N16236(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) shark = new Shark(i, j, 2, 0);
            }
        }

        int help = 0;

        while (true){
            int hunt = BFS();
            if(hunt == 0) break;
            else {
                shark.x = minDist.x;
                shark.y = minDist.y;
                shark.feed += 1;

                if(shark.feed == shark.size){
                    shark.feed = 0;
                    shark.size += 1;
                }

                help += hunt;
            }
        }

        System.out.println(help);

    }

    public int BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(shark.x, shark.y));

        feedMap = new int[n][n];
        feedMap[shark.x][shark.y] = 1;
        map[shark.x][shark.y] = 0;
        boolean check = false;

        dist = 1000;
        minDist = new Point(1000, 1000);

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && feedMap[nx][ny] == 0){

                    if(map[nx][ny] == 0 || shark.size == map[nx][ny]){
                        feedMap[nx][ny] = feedMap[temp.x][temp.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                    else if(shark.size > map[nx][ny] && map[nx][ny] != 0){
                        feedMap[nx][ny] = feedMap[temp.x][temp.y] + 1;
                        check = true;

                        if(dist > feedMap[nx][ny]){
                            dist = feedMap[nx][ny];
                            minDist.x = nx;
                            minDist.y = ny;
                        }
                        else if(dist == feedMap[nx][ny]){
                            if(minDist.x == nx){
                                if(minDist.y > ny){
                                    minDist.x = nx;
                                    minDist.y = ny;
                                }
                            }
                            else if(minDist.x > nx){
                                minDist.x = nx;
                                minDist.y = ny;
                            }
                        }
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        if(check) return dist-1;
        else return 0;
    }

}
