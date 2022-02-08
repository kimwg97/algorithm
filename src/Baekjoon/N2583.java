package Baekjoon;

import java.awt.*;
import java.util.*;

public class N2583 {

    public int BFS(int[][] board, Point start, int m, int n) {
        //-----BFS 사용하여 지역과 그 크기 찾기-----
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int placeSize = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = temp.x + dx[j];
                    int y = temp.y + dy[j];
                    System.out.println("next place: " + x + ", " + y);
                    if (x < n && x >= 0 && y < m && y >= 0 && board[y][x] != 1) {
                        System.out.println("change place: " + x + ", " + y);
                        q.offer(new Point(x, y));
                        board[y][x] = 1;
                        placeSize++;
                    }
                }
            }
        }
        System.out.println("placeSize: " + placeSize);
        return placeSize;
    }

    public void Solution(){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] board = new int[m][n];

        //-----이차원 그래프 그리기-----
        for(int i = 0; i < k; i++){
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();
            for(int j = 0; j < m; j++){
                for(int h = 0; h < n; h++){
                    if(j >= ly && j < ry && h >= lx && h < rx && board[j][h] != 1) board[j][h] = 1;
                }
            }
        }

        int placeCount = 0;
        ArrayList<Integer> placeSizeList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    System.out.println(i + ", " + j);
                    placeCount++;
                    board[i][j] = 1;
                    placeSizeList.add(BFS(board, new Point(j, i), m, n));
                }
            }
        }

        System.out.println(placeCount);
        Collections.sort(placeSizeList);
        for(int i = 0; i < placeSizeList.size(); i++) System.out.print(placeSizeList.get(i) + " ");

    }
}
