package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N13459 {
    int n, m;
    char[][] board;
    boolean[][][][] check;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public class Point{
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public class Turn {
        int rx, ry, bx, by;

        public Turn(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    Point red, blue, o;

    public void N13459(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        check = new boolean[n][m][n][m];

        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R') red = new Point(i, j, 0);
                else if(board[i][j] == 'B') blue = new Point(i, j , 0);
                else if(board[i][j] == 'O') o = new Point(i, j, 0);
            }
        }

        int result = BFS(red.x, red.y, blue.x, blue.y);
        System.out.println(result);
    }

    private int BFS(int rdr, int rdc, int blr, int blc) {

        Queue<Turn> q = new LinkedList<>();
        int time = 1;

        q.add(new Turn(rdr, rdc, blr, blc));
        check[rdr][rdc][blr][blc] = true;

        Point nRed = null, nBlue = null;
        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                Turn now = q.poll();

                // 4방으로 장난감을 기울여보자.
                for (int d = 0; d < 4; d++) {
                    // 빨간 구슬 이동
                    nRed = move(now.rx, now.ry, 0, d);
                    // 파랑 구슬 이동
                    nBlue = move(now.bx, now.by, 0, d);

                    // 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
                    if(board[nBlue.x][nBlue.y] == 'O') continue;
                    // 빨간 구슬만 구멍에 빠질 경우
                    if(board[nRed.x][nRed.y] == 'O') return time;

                    // 빨간 구슬과 파란 구슬이 같은 칸에 있을 경우
                    if (nRed.x == nBlue.x && nRed.y == nBlue.y) {
                        // 빨간 구슬이 더 많이 이동했을 경우
                        if(nRed.distance> nBlue.distance) {
                            // 이전 위치로
                            nRed.x -= dx[d];
                            nRed.y -= dy[d];
                        } else {
                            nBlue.x -= dx[d];
                            nBlue.y -= dy[d];
                        }
                    }

                    // 이미 시도해봤던 상태라면 pass
                    if(check[nRed.x][nRed.y][nBlue.x][nBlue.y]) continue;

                    check[nRed.x][nRed.y][nBlue.x][nBlue.y] = true;

                    // Queue에 추가
                    q.add(new Turn(nRed.x, nRed.y, nBlue.x, nBlue.y));
                }
            }

            // 10번 이하로 성공할 수 없다면
            if(++time > 10) return -1;
        }
        return -1;
    }

    private Point move(int r, int c, int dist, int d) {

        int rr = r, cc = c;
        // 다음 칸이 벽이 아니고, 현재 칸이 구멍이 아니라면 계속 이동
        while(board[rr + dx[d]][cc + dy[d]] != '#' && board[rr][cc] != 'O') {
            rr += dx[d];
            cc += dy[d];
            dist++;
        }

        return new Point(rr, cc, dist);
    }
}
