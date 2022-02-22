package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class N6593 {
    int l, r, c;
    char[][][] building;
    int[][][] check;

    public class Point{
        int z;
        int y;
        int x;
        public Point(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    int[] dz = {1, -1, 0, 0, 0, 0};
    int[] dx = {0, 0, 1, 0, -1, 0};
    int[] dy = {0, 0, 0, -1, 0, 1};

    Point start, end;

    public void N6593(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            if (l == 0 && r == 0 && c == 0) break;
            building = new char[l][r][c];
            check = new int[l][r][c];

            for (int f = 0; f < l; f++) {
                for (int i = 0; i < r; i++) {
                    String s = sc.next();
                    for (int j = 0; j < c; j++) {
                        building[f][i][j] = s.charAt(j);
                        if (building[f][i][j] == 'S') start = new Point(f, i, j);
                        else if (building[f][i][j] == 'E') end = new Point(f, i, j);
                    }
                }
            }

            BFS();
        }
    }
    public void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        int count = 0;

        while(!q.isEmpty()){
            Point temp = q.poll();

            if(building[temp.z][temp.y][temp.x] == 'E') {
                count = check[temp.z][temp.y][temp.x];
                break;
            }

            for(int j = 0; j < 6; j++){
                int z = dz[j] + temp.z;
                int y = dy[j] + temp.y;
                int x = dx[j] + temp.x;
                if(z >= 0 && y >= 0 && x >= 0 && z < l && y < r && x < c && building[z][y][x] != '#'){
                    building[temp.z][temp.y][temp.x] = '#';
                    check[z][y][x] = check[temp.z][temp.y][temp.x] + 1;
                    q.offer(new Point(z, y, x));
                }
            }
        }

        if(count > 0) System.out.println("Escaped in " + count + " minute(s).");
        else System.out.println("Trapped!");
    }
}
