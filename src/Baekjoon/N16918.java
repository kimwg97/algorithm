package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N16918 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    char[][][] map;

    int r, c;

    public void N16918(){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        int n = sc.nextInt();

        map = new char[6][r][c];
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Point> list2 = new ArrayList<>();

        for(int i = 0; i < r; i++){
            String str = sc.next();
            for(int j = 0; j < c; j++){
                map[0][i][j] = str.charAt(j);
                map[1][i][j] = str.charAt(j);       //1초는 그대로 있으므로
                if(map[0][i][j] == 'O') list.add(new Point(i, j));
            }
        }

        for(int i = 0; i < r; i++){
            Arrays.fill(map[2][i], 'O');        //2초는 모두 폭탄
            Arrays.fill(map[3][i], 'O');
            Arrays.fill(map[4][i], 'O');        //4초도 모두 폭탄
            Arrays.fill(map[5][i], 'O');
        }

        //3초는 0초 때 심었던 폭탄이 폭발
        for(Point p : list) {
            for (int i = 0; i < 4; i++) {
                map[3][p.x][p.y] = '.';
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                    map[3][nx][ny] = '.';
                }
            }
        }

        //2초에 심은 폭탄 조사
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[3][i][j] == 'O') list2.add(new Point(i, j));     //3초 때 폭탄이었던 것들 저장 -> 2초 때 심었던 것
            }
        }

        //5초는 2초 때 심었던 폭탄이 폭발
        for(Point p : list2) {
            for (int i = 0; i < 4; i++) {
                map[5][p.x][p.y] = '.';
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    map[5][nx][ny] = '.';
                }
            }
        }

        //map[0], map[1]은 단독적이고
        if(n == 1 || n == 0) Print(1);
        else if(n % 2 == 0) Print(2);
        else if(n % 4 == 1) Print(5);
        else if(n % 4 == 3) Print(3);
        }

        public void Print(int num){
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    System.out.print(map[num][i][j]);
                }
                System.out.println();
            }
        }
}
