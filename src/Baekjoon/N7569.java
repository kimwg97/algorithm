package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7569 {

    public class Tomato{
        int x;
        int y;
        int z;
        public Tomato(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


    int n, m, h;
    int[][][] map;
    ArrayList<Tomato> ripedTomato = new ArrayList<>();

    int[] dx = {0, 0, 1, 0, -1, 0};
    int[] dy = {0, 0, 0, -1, 0, 1};
    int[] dz = {1, -1, 0, 0, 0, 0,};

    int count = 0;

    public void N7569(){
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        map = new int[h][n][m];

        boolean flag = false;

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    map[k][i][j] = sc.nextInt();
                    if(map[k][i][j] == 0) flag = true;
                    else if(map[k][i][j] == 1) ripedTomato.add(new Tomato(i, j, k));
                }
            }
        }

        if(!flag) System.out.println(0);
        else{

            tomatoRipe();

            flag = true;
            for(int k = 0; k < h; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[k][i][j] == 0) flag = false;
                    }
                }
            }

            if(flag) System.out.println(count-1);
            else System.out.println(-1);
        }

    }

    public void tomatoRipe(){
        Queue<Tomato> q = new LinkedList<>();
        for(Tomato t : ripedTomato) q.add(t);

        while (!q.isEmpty()){
            int l = q.size();

            for(int g = 0; g < l; g++) {
                Tomato temp = q.poll();

                for(int i = 0; i < 6; i++){
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    int nz = temp.z + dz[i];

                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h && map[nz][nx][ny] == 0){
                        map[nz][nx][ny] = 1;
                        q.add(new Tomato(nx, ny, nz));
                    }
                }
            }
            count++;
        }
    }
}
