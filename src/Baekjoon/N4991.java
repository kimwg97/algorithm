package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N4991 {
    int n, m;
    char[][] map;
    int[][] check;
    Point start;
    int dirty;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void N4991(){
        Scanner sc = new Scanner(System.in);

        while(true){
            m = sc.nextInt();
            n = sc.nextInt();

            if(m == 0) break;

            map = new char[n][m];
            dirty = 0;

            for(int i = 0; i < n; i++){
                String str = sc.next();
                for(int j = 0; j < m; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'o') start = new Point(i, j);
                    else if(map[i][j] == '*') dirty++;
                }
            }

            int result = BFS();
            System.out.println(result);
        }
    }

    public int BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int dirtyCount = 0;

        check = new int[n][m];

        while (!q.isEmpty()){
            Point temp = q.poll();
            int now = check[temp.x][temp.y];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && check[nx][ny] == 0 && map[nx][ny] != 'X'){
                    if(map[nx][ny] == '*'){
                        dirtyCount++;
                        System.out.println("줍기전");
                        for(int j = 0; j < n; j++){
                            for(int h  = 0; h < m; h++) System.out.print(check[j][h] + " ");
                            System.out.println();
                        }
                        System.out.println();
                        if(dirtyCount == dirty){
                            return now + 1;
                        }

                        // 맵, 체크, 큐는 초기화
                        map[nx][ny] = '.';
                        check = new int[n][m];
                        q.clear();

                        // 카운트는 그대로 진행해야 함
                        check[nx][ny] = now + 1;
                        q.add(new Point(nx, ny));

                        System.out.println("주운뒤");
                        for(int j = 0; j < n; j++){
                            for(int h  = 0; h < m; h++) System.out.print(map[j][h] + " ");
                            System.out.println();
                        }
                        System.out.println();

                        break;
                    }
                    else if(map[nx][ny] == '.'){
                        check[nx][ny] = now + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }

        }
        return -1;
    }


}
