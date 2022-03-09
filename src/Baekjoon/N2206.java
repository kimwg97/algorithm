package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2206 {
    int n, m;

    int[][] map;
    int[][][] check;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public class state{
        int x;
        int y;
        int crush;

        public state(int x, int y, int crush){
            this.x = x;
            this.y = y;
            this.crush = crush;
        }
    }

    public void N2206(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        check = new int[n][m][2];

        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j = 0; j < m; j++) map[i][j] = Character.getNumericValue(str.charAt(j));
        }

        System.out.println(BFS());
    }

    public int BFS(){
        Queue<state> q = new LinkedList<>();
        q.add(new state(0, 0, 0));

        map[0][0] = 3;
        check[0][0][0] = 1;

        while(!q.isEmpty()){
            state temp = q.poll();

            if(temp.x == n-1 && temp.y == m-1) return check[temp.x][temp.y][0];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(map[nx][ny] == 0){
                        if(temp.crush == 0) map[nx][ny] = 3;
                        else map[nx][ny] = 2;
                        check[nx][ny][0] = check[temp.x][temp.y][0] + 1;
                        q.add(new state(nx, ny, temp.crush));
                    }
                    else if(map[nx][ny] == 1){
                        if(check[nx][ny][1] == 0 && temp.crush == 0) {
                            check[nx][ny][1] = check[temp.x][temp.y][0] + 1;
                            check[nx][ny][0] = check[temp.x][temp.y][0] + 1;
                            q.add(new state(nx, ny, temp.crush + 1));
                        }
                    }
                    else if(map[nx][ny] == 2){
                        if(temp.crush == 0){
                            map[nx][ny] = 3;
                            check[nx][ny][0] = check[temp.x][temp.y][0] + 1;
                            q.add(new state(nx, ny, temp.crush));
                        }
                    }
                }
//
//                for(int j = 0; j < n; j++){
//                    for(int h = 0; h < m; h++) System.out.print(map[j][h] + " ");
//                    System.out.println();
//                }
//                System.out.println();
            }
        }

        return -1;
    }
}
