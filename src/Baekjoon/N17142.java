package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N17142 {
    int n, m;
    int[][] map;
    int[][] brick;
    int[][] copied;
    int[] virus;
    ArrayList<Point> start = new ArrayList<>();

    int min = Integer.MAX_VALUE;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public void N17142(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        brick = new int[n][n];
        copied = new int[n][n];
        virus = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) brick[i][j] = 1;
                else if(map[i][j] == 2){
                    brick[i][j] = -1;
                    start.add(new Point(i, j));
                }
            }
        }

        DFS(0, 0);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else if(min == 0) System.out.println(min);
        else System.out.println(min-2);
    }

    // DFS 에서 보내준 조합을 시작점으로 바이러스가 퍼진다
    public void BFS(){
        Queue<Point> q = new LinkedList<>();
        int count = 0;

        mapCopy();
        for(int i = 0; i < m; i++){
            int x = start.get(virus[i]).x;
            int y = start.get(virus[i]).y;
            copied[x][y] = 2;
            q.add(new Point(x, y));
        }

        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && ny < n && nx < n){
                    if(copied[nx][ny] == 0) {
                        int c;
                        if(copied[temp.x][temp.y] > 0) c = copied[temp.x][temp.y] + 1;
                        else c = -1 * copied[temp.x][temp.y] + 2;
                        copied[nx][ny] = c;
                        count = Math.max(count, c);
                        if (count > min) return;
                        q.add(new Point(nx, ny));
                    }else if(copied[nx][ny] == -1){
                        if(copied[temp.x][temp.y] > 0) copied[nx][ny] = -1 * copied[temp.x][temp.y];
                        else copied[nx][ny] = copied[temp.x][temp.y] - 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        if(Check()) min = Math.min(count, min);
    }

    // 입력에서 받은 시작 후보들을 조합해서 BFS 에 넘긴다
    public void DFS(int l, int c){
        if(l == m){
            BFS();
        }else{
            for(int i = c; i < start.size(); i++){
                virus[l] = i;
                DFS(l+1, i+1);
            }
        }
    }

    // 벽돌만 있는 맵을 복사
    public void mapCopy(){
        copied = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                copied[i][j] = brick[i][j];
            }
        }
    }

    // 해당 맵에 안전 지역이 있는지 확인
    public boolean Check(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(copied[i][j] == 0) return false;
            }
        }
        return true;
    }
}
