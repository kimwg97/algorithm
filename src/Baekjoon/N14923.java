package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14923 {

    public class P{
        int x;
        int y;
        int count;
        public P(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    int n, m;
    P s, e;
    int[][] map;
    int[][][] check;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N14923(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        check = new int[n][m][2];
        s = new P(sc.nextInt()-1, sc.nextInt()-1, 0);
        e = new P(sc.nextInt()-1, sc.nextInt()-1, 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int result = BFS();
        System.out.println(result);
    }

    public int BFS(){
        Queue<P> q = new LinkedList<>();
        q.add(s);
        map[s.x][s.y] = 2;

        while (!q.isEmpty()){
            P temp = q.poll();

            if(temp.x == e.x && temp.y == e.y) return check[temp.x][temp.y][0];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(map[nx][ny] == 0) {
                        check[nx][ny][0] = check[temp.x][temp.y][0] + 1;
                        q.add(new P(nx, ny, temp.count));
                    }
                    else if(map[nx][ny] == 1){
                        if(temp.count == 0 && check[nx][ny][1] == 0){
                            check[nx][ny][1] = 1;
                            check[nx][ny][0] = check[temp.x][temp.y][0] + 1;
                            q.add(new P(nx, ny, temp.count+1));
                        }
                    }
                }
            }
        }

        return -1;
    }


}
