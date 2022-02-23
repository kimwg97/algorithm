package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N13459 {

    public class Point{
        int x;
        int y;
        int up;
        int right;
        int count;
        int m;
        public Point(int x, int y, int count, int up, int right, int m){
            this.x = x;
            this.y = y;
            this.count = count;
            this.up = up;
            this.right = right;
            this.m = m;
        }
    }

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
                if(board[i][j] == 'R') red = new Point(j, i, 0, 0, 0, 4);
                else if(board[i][j] == 'B') blue = new Point(j, i, 0, 0, 0, 4);
                else if(board[i][j] == 'O') o = new Point(j, i, 0, 0, 0, 0);
            }
        }

        compare(red, blue);

        int result = BFS();
        System.out.println(result);
    }

    public void compare(Point r, Point b){
        if(r.x < b.x){
            b.right = 2;
            r.right = 1;
        }else{
            b.right = 1;
            r.right = 2;
        }

        if(r.y < b.y){
            b.up = 1;
            r.up = 2;
        }else{
            b.up = 2;
            r.up = 1;
        }

        if(r.x == b.x){
            b.right = 0;
            r.right = 0;
        }
    }


    public Point move(Point marble, int d){
        int i;
        // 오른쪽으로
        if(d == 0){
            for(i = marble.x; board[marble.y][i] != '#'; i++){
                if(marble.y == o.y && i == o.x) return o;
            } return new Point(i-1, marble.y, marble.count+1, marble.up, marble.right, 0);
        }
        // 왼쪽으로
        else if(d == 1){
            for(i = marble.x; board[marble.y][i] != '#'; i--) {
                if(marble.y == o.y && i == o.x) return o;
            } return new Point(i+1, marble.y, marble.count+1, marble.up, marble.right, 1);
        }
        // 아래로
        else if(d == 2){
            for(i = marble.y; board[i][marble.x] != '#'; i++){
                if(i == o.y && marble.x == o.x) return o;
            } return new Point(marble.x, i-1, marble.count+1, marble.up, marble.right, 2);
        }
        // 위로
        else{
            for(i = marble.y; board[i][marble.x] != '#'; i--){
                if(i == o.y && marble.x == o.x) return o;
            } return new Point(marble.x, i+1, marble.count+1, marble.up, marble.right, 3);
        }
    }

    // 벽에 먼저 박은 구슬이 있으면 그 구슬은 거기서 멈추지만, 다른 구슬은 멈춘 구슬과 겹치는 게 아닌 이상 움직일 수 있음
    // 그리고 생각해보면 장애물을 만나면 멈추는 거지 가장자리에서 멈추는 게 아니네... 조금 더 생각해봐야 함.

    public int BFS(){
        Queue<ArrayList<Point>> q = new LinkedList<>();
        ArrayList<Point> marbles = new ArrayList<>();
        marbles.add(red);
        marbles.add(blue);
        q.add(marbles);
        int bHole = 11;

        while(!q.isEmpty()){
            ArrayList<Point> temp = q.poll();
            Point r = temp.get(0);
            Point b = temp.get(1);

            if(r.count > 10) break;
            //구슬이 겹쳤을 경우
            if(r.x == b.x && r.y == b.y){
                // 오른쪽으로 보내진 구슬임
                if(r.m == 0){
                    if (r.right == 2) b.x = b.x - 1;
                    else r.x = r.x - 1;
                }
                // 왼쪽으로 보내진 구슬임
                else if(r.m == 1){
                    if (r.right == 2) r.x = r.x + 1;
                    else b.x = b.x + 1;
                }
                // 아래로 보내진 구슬임
                else if(r.m == 2){
                    if (r.up == 2) r.y = r.y - 1;
                    else b.y = b.y - 1;
                }
                // 위로 보내진 구슬임
                else{
                    if (r.up == 2) b.y = b.y + 1;
                    else r.y = r.y + 1;
                }
            }

            if(b.x == o.x && b.y == o.y) bHole = Math.min(bHole, b.count);  // 파란색이 떨어진 최속 경로를 저장
            if(r.x == o.x && r.y == o.y){                                   // 빨간색이 우선 떨어짐
                if(r.count < bHole) return 1;                               // 파란색보다 빠르게 떨어지면 상관없이 성공
                else if(r.count == bHole){                                  // 그런데 같은 횟수로 떨어졌다면 두가지로 나뉨
                    if(b.x == o.x && b.y == o.y) return 0;                  // 동시에 떨어진 경우
                    else return 1;                                          // 동시는 아니고 다른 방향으로 빨간색이 먼저 떨어진 경우, 다른 방향으론 파란색이 먼저 떨어짐
                }
                else return 0;
            }

            for(int i = 0; i < 4; i++){
                if(r.m == i) continue;
                //System.out.println(i);
                ArrayList<Point> next = new ArrayList<>();
                Point rNext = move(r, i);
                Point bNext = move(b, i);

                compare(rNext, bNext);
                next.add(rNext);
                next.add(bNext);
                q.add(next);
            }
        }
        return 0;
    }
}
