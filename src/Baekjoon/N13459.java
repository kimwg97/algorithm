package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N13459 {

    public class Point{
        int x;
        int y;
        int count;
        public Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};

    Point red, blue, o;
    char[][] board;
    int[][] rCheck;
    int[][] bCheck;
    int n, m;

    public void N13459(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        rCheck = new int[n][m];
        bCheck = new int[n][m];

        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R') red = new Point(j, i, 0);
                else if(board[i][j] == 'B') blue = new Point(j, i, 0);
                else if(board[i][j] == 'O') o = new Point(j, i, 0);
            }
        }

        int result = BFS();
        System.out.println(result);
    }

    public Point move(Point marble, int d){
        int i;
        if(d == 0){
            for(i = marble.y; board[i][marble.x] != '#'; i++){
                if(i == o.y && marble.x == o.x) return o;
            } return new Point(marble.x, i, marble.count+1);
        }
        else if(d == 1){
            for(i = marble.y; board[i][marble.x] != '#'; i--){
                if(i == o.y && marble.x == o.x) return o;
            } return new Point(marble.x, i, marble.count+1);
        }
        else if(d == 2){
            for(i = marble.x; board[marble.y][i] != '#'; i++){
                if(marble.y == o.y && i == o.x) return o;
            } return new Point(i, marble.x, marble.count+1);
        }
        else{
            for(i = marble.x; board[marble.y][i] != '#'; i--){
                if(marble.y == o.y && i == o.x) return o;
            } return new Point(i, marble.y, marble.count+1);
        }
    }


    // 벽에 먼저 박은 구슬이 있으면 그 구슬은 거기서 멈추지만, 다른 구슬은 멈춘 구슬과 겹치는 게 아닌 이상 움직일 수 있음
    // 그리고 생각해보면 장애물을 만나면 멈추는 거지 가장자리에서 멈추는 게 아니네... 조금 더 생각해봐야 함.

    public int BFS(){
        Queue<ArrayList<Point>> q = new LinkedList<>();
        ArrayList<Point> marble = new ArrayList<>();
        marble.add(red);
        marble.add(blue);
        q.add(marble);
        int bHole = 11;

        while(!q.isEmpty()){
            ArrayList<Point> temp = q.poll();
            Point rTemp = temp.get(0);
            Point bTemp = temp.get(1);

            if(rTemp.count > 10) break;

            if(rTemp.x == o.x && rTemp.y == o.y){
                if(rTemp.count <= bHole) return 1;
                else return 0;
            }
            if(bTemp.x == o.x && bTemp.y == o.y) bHole = Math.min(bHole, bTemp.count);

            for(int i = 0; i < 4; i++){
                ArrayList<Point> next = new ArrayList<>();
                next.add(rTemp);
                next.add(bTemp);
                q.add(next);
            }
        }

        return 0;
    }
}
