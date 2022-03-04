package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N3055 {
    Point s;
    ArrayList<Point> water = new ArrayList<>();
    int r, c;
    int[][] check;
    char[][] map;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N3055(){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        check = new int[r][c];

        for(int i = 0; i < r; i++){
            String str = sc.next();
            for(int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') s = new Point(i, j);
                else if(map[i][j] == '*') water.add(new Point(i, j));
            }
        }

        int result = BFS();
        if(result == 0) System.out.println("KAKTUS");
        else System.out.println(result);

    }

    public int BFS(){
        Queue<Point> q = new LinkedList<>();
        Queue<Point> waters = new LinkedList<>();
        q.add(s);

        for(int i = 0; i < water.size(); i++) waters.add(water.get(i));

        while(!q.isEmpty()){
            //물이 먼저 차오름
            int len = waters.size();

            for(int k = 0; k < len; k++){
                Point temp = waters.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.'){
                        map[nx][ny] = '*';
                        waters.add(new Point(nx, ny));
                    }
                }
            }
            //물이 차오르고 두더지가 이동함
            int qLen = q.size();

            for(int k = 0; k < qLen; k++) {
                Point next = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = next.x + dx[i];
                    int ny = next.y + dy[i];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != '*' && map[nx][ny] != 'S' && map[nx][ny] != 'X') {
                        check[nx][ny] = check[next.x][next.y] + 1;
                        if(map[nx][ny] == 'D') return check[nx][ny];
                        map[nx][ny] = 'S';
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        return 0;
    }
}
