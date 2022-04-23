package Baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N11559 {

    char[][] map = new char[12][6];
    char[][] copy = new char[12][6];

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    boolean flag = false;

    public void N11559(){
        Scanner sc = new Scanner(System.in);
        int n = 12;
        int m = 6;
        int c = 0;

        for(int i = 0; i < n; i++){
            String x = sc.next();
            for(int j = 0; j < m; j++){
                map[i][j] = x.charAt(j);
            }
        }
        boolean ch;
        //위에서부터 시작하여 '.'이 아닌 경우 = 뿌요가 있는 경우 boom 실행
        //근데 이렇게 돌리면 지나간 자리에 다시 뿌요가 떨어질 확률도 있을 수 있음
        while (true) {
            ch = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != '.') {
                        char color = map[i][j];
                        CopyMap();
                        flag = false;
                        copy[i][j] = '.';

                        check(color, i, j);

                        if (flag) {
                            ch = true;
                            CopyCopy();
                        }
                    }
                }
            }
            if(ch) {
                c++;
                gravity();
            }
            else break;
        }

        System.out.println(c);
//        System.out.println();
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++) System.out.print(map[i][j]);
//            System.out.println();
//        }

    }

    //주변에 같은 색의 뿌요가 몇개가 있는지 확인
    public void check(char color, int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        int count = 1;

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && copy[nx][ny] == color){
                    copy[nx][ny] = '.';
                    count++;
                    q.add(new Point(nx, ny));
                }
            }
        }
        if(count >= 4) flag = true;
    }

    //연쇄 반응이 일어난 후 뿌요를 아래로 내려야 함
    public void gravity(){
        boolean ch;
        boolean first;
        Point f = new Point();

        for(int j = 0; j < 6; j++){
            first = true;
            ch = false;
            for(int i = 11; i >= 0; i--){
                if(map[i][j] == '.'){
                    ch = true;

                    if(first){
                        first = false;
                        f.x = i;
                        f.y = j;
                    }
                }

                if(ch){
                    if(map[i][j] != '.'){
                        map[f.x][f.y] = map[i][j];
                        map[i][j] = '.';
                        f.x = f.x - 1;
                    }
                }
            }
        }
    }

    public void CopyMap(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                copy[i][j] = map[i][j];
            }
        }
    }

    public void CopyCopy(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                map[i][j] = copy[i][j];
            }
        }
    }
}
