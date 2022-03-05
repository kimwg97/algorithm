package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14923 {
    int n, m;
    Point s, e;
    int[][] map;
    public void N14923(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        s = new Point(sc.nextInt()-1, sc.nextInt()-1);
        e = new Point(sc.nextInt()-1, sc.nextInt()-1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

    }

    public void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(s);
    }


}
