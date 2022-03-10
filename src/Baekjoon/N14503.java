package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N14503 {
    int n, m;
    int[][] map;
    int[][] check;

    // 북 0 동 1 남 2 서 3
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public class robot{
        int x;
        int y;
        int dir;

        public robot(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    robot r;

    public void N14503(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = new robot(sc.nextInt(), sc.nextInt(), sc.nextInt());

        map = new int[n][m];
        check = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) map[i][j] = sc.nextInt();
        }

        System.out.println(BFS());
    }

    public int BFS(){
        Queue<robot> q = new LinkedList<>();
        q.add(r);
        int count = 0;

        while(!q.isEmpty()){
            robot temp = q.poll();

//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++) System.out.print(check[i][j] + " ");
//                System.out.println();
//            }
//            System.out.println();
//
//            if(temp.x == 5 && temp.y == 4) System.out.println(temp.dir);

            if(check[temp.x][temp.y] == 0) {
                count++;                        // 청소했으니까 count + 1
                check[temp.x][temp.y] = 1;      // 청소했다는 것을 의미
            }

            int d = temp.dir;

            // 왼쪽으로 4번 돌아서 청소할 자리를 확인해 봄
            // 반시계로 돌아줘야 함
            for(int i = 0; i < 4; i++){
                d = Left(d);
//                if(i == 3) System.out.println(d);
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0){
                    if(check[nx][ny] == 0) {        // 아직 청소하지 않은 자리임을 의미
                        q.add(new robot(nx, ny, d));
//                        System.out.println("진행 방향: " + d);
//                        System.out.println("-회전 회수-: " + i);
//                        System.out.println(nx + "," + ny);
                        break;
                    }
                }
                if(i == 3 && q.isEmpty()){   // 근데 만약 청소할 곳이 없을 때
//                    System.out.println(3333);
                    int b = back(temp.dir);
                    int bx = dx[b] + temp.x;
                    int by = dy[b] + temp.y;
                    if(bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] == 0) {    // 후진이 가능하다면
                        q.add(new robot(bx, by, temp.dir));
                    }else{                                                              // 후진도도안된다면
                        return count;                                                   // 종료
                    }
                }
            }
        }

        return count;
    }

    // 북 0 동 1 남 2 서 3
    public int Left(int i){
        if(i == 0){         // 바라보는 방향이 북쪽일경우
            return 3;       // 서쪽으로
        }
        else if(i == 1){    // 바라보는 방향이 동쪽일경우
            return 0;       // 북쪽으로
        }
        else if(i == 2){    // 바라보는 방향이 남쪽일경우
            return 1;       // 동쪽으로
        }
        else{               // 바라보는 방향이 서쪽일경우
            return 2;       // 남쪽으로
        }
    }

    // 북 0 동 1 남 2 서 3
    public int back(int i){
        if(i == 0){         // 바라보는 방향이 북쪽일경우
            return 2;       // 남쪽으로
        }
        else if(i == 1){    // 바라보는 방향이 동쪽일경우
            return 3;       // 서쪽으로
        }
        else if(i == 2){    // 바라보는 방향이 남쪽일경우
            return 0;       // 북쪽으로
        }
        else{               // 바라보는 방향이 서쪽일경우
            return 1;       // 동쪽으로
        }
    }


}
