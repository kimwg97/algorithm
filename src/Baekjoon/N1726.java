package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1726 {
    public class Location{
        int x;
        int y;
        int direction;
        int command;
        public Location(int x, int y, int direction, int command){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.command = command;
        }
    }

    //동 1 서 2 남 3 북 4
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int m, n;
    int[][] map;
    int check[][];

    Location robot, end;

    public void N1726(){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        check = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) map[i][j] = sc.nextInt();
        }

        robot = new Location(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), 0);
        end = new Location(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), 0);

        int result = BFS();
        if(result == 0) System.out.println("탈출이 안댐");
        else System.out.println(result);
    }

    public int BFS(){
        Queue<Location> q = new LinkedList<>();
        q.add(robot);
        map[robot.x][robot.y] = 1;

        while (!q.isEmpty()){
            Location temp = q.poll();

            // 목적지 도착
            if(temp.x == end.x && temp.y == end.y){
                for(int i = 0; i < m; i++){
                    for(int j  = 0; j < n; j++) System.out.print(map[i][j] + " ");
                    System.out.println();
                }
                return temp.command;
            }

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] != 1){
                    System.out.println("시작점 " + temp.x + ", " + temp.y);
                    int dir = RobotDirection(temp.direction, i);
                    int newCommand = temp.command + dir + 1;            //현재 커맨드 수 + 방향조절 커맨드 + 전진 커맨드

                    // 가려는 칸이 0이거나 커맨드 수가 더 많다면
                    if(map[nx][ny] == 0 || map[nx][ny] > newCommand) {
                        map[nx][ny] = newCommand;
                        if(nx == end.x && ny == end.y){
                            if(i+1 == end.direction) return newCommand;
                            else{
                                newCommand = newCommand + RobotDirection(i+1, end.direction-1);
                                if(newCommand < map[nx][ny]) {
                                    map[nx][ny] = newCommand;
                                    q.add(new Location(nx, ny, end.direction, newCommand));
                                }
                            }
                        }else {
                            q.add(new Location(nx, ny, i + 1, newCommand));
                            System.out.println("-넣은점 " + nx + ", " + ny);
                        }
                        //이미 한칸은 움직인 상황 -> 2칸 3칸도 이동 가능한가 따져봄
                        nx = dx[i] + nx;
                        ny = dy[i] + ny;
                        if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] != 1) {
                            if (map[nx][ny] == 0 || map[nx][ny] > newCommand) {
                                map[nx][ny] = newCommand;
                                if(nx == end.x && ny == end.y) {
                                    if (i + 1 == end.direction) return newCommand;
                                    else {
                                        newCommand = newCommand + RobotDirection(i+1, end.direction - 1);
                                        if(newCommand < map[nx][ny]) {
                                            map[nx][ny] = newCommand;
                                            q.add(new Location(nx, ny, end.direction, newCommand));
                                        }
                                    }
                                }else q.add(new Location(nx, ny, i + 1, newCommand));
                                System.out.println("-넣은점 " + nx + ", " + ny);
                                // 3칸도 가능한지
                                nx = dx[i] + nx;
                                ny = dy[i] + ny;
                                if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] != 1) {
                                    if (map[nx][ny] == 0 || map[nx][ny] > newCommand) {
                                        map[nx][ny] = newCommand;
                                        if(nx == end.x && ny == end.y) {
                                            if (i + 1 == end.direction) return newCommand;
                                            else {
                                                newCommand = newCommand + RobotDirection(i+1, end.direction - 1);
                                                if(newCommand < map[nx][ny]) {
                                                    map[nx][ny] = newCommand;
                                                    q.add(new Location(nx, ny, end.direction, newCommand));
                                                }
                                            }
                                        }else q.add(new Location(nx, ny, i + 1, newCommand));
                                        System.out.println("-넣은점 " + nx + ", " + ny);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    //추가할 커맨드 수를 리턴
    public int RobotDirection(int now, int dir){
        if(dir == 0){   //동쪽
            if(now == 1) return 0;
            else if(now == 2) return 2;
            else return 1;
        }
        else if(dir == 1){      //서쪽
            if(now == 2) return 0;
            else if(now == 1) return 2;
            else return 1;
        }
        else if(dir == 2){      //남쪽
            if(now == 3) return 0;
            else if(now == 4) return 2;
            else return 1;
        }
        else{                   //북쪽
            if(now == 4) return 0;
            else if(now == 3) return 2;
            else return 1;
        }
    }
}
