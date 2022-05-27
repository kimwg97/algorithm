package Baekjoon;

import java.awt.*;
import java.util.Scanner;

public class N14499 {

    public class Dice{
        int top;
        int under;
        int up;
        int down;
        int left;
        int right;

        public Dice(int top, int under, int up, int down, int left, int right){
            this.top = top;
            this.under = under;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }

    int n, m, com;
    Point location;
    int[] command;
    int[][] map;

    Dice dice;

    public void N14499(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        location = new Point(sc.nextInt(), sc.nextInt());
        com = sc.nextInt();

        command = new int[com];
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < com; i++) command[i] = sc.nextInt();

        dice = new Dice(0, 0, 0, 0, 0, 0);

        roll();
    }

    public void roll(){
        for(int i = 0; i < com; i++){
            move(command[i]);
//            for(int j = 0; j < n; j++){
//                for(int k = 0; k < m; k++){
//                    System.out.print(map[j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }

    public void move(int d){
        int nx, ny;

        if(d == 1){
            ny = location.y + 1;

            if(ny < m){
                location.y = ny;

                int temp = dice.top;
                dice.top = dice.left;
                dice.left = dice.under;
                dice.under = dice.right;
                dice.right = temp;

                if(map[location.x][ny] == 0) map[location.x][ny] = dice.under;
                else{
                    dice.under = map[location.x][ny];
                    map[location.x][ny] = 0;
                }

                System.out.println(dice.top);
            }
        }
        else if(d == 2){
            ny = location.y - 1;

            if(ny >= 0){
                location.y = ny;

                int temp = dice.top;
                dice.top = dice.right;
                dice.right = dice.under;
                dice.under = dice.left;
                dice.left = temp;

                if(map[location.x][ny] == 0) map[location.x][ny] = dice.under;
                else{
                    dice.under = map[location.x][ny];
                    map[location.x][ny] = 0;
                }

                System.out.println(dice.top);
            }
        }
        else if(d == 3){
            nx = location.x - 1;

            if(nx >= 0){
                location.x = nx;

                int temp = dice.top;
                dice.top = dice.down;
                dice.down = dice.under;
                dice.under = dice.up;
                dice.up = temp;

                if(map[nx][location.y] == 0) map[nx][location.y] = dice.under;
                else{
                    dice.under = map[nx][location.y];
                    map[nx][location.y] = 0;
                }

                System.out.println(dice.top);
            }
        }
        else{
            nx = location.x + 1;

            if(nx < n){
                location.x = nx;

                int temp = dice.top;
                dice.top = dice.up;
                dice.up = dice.under;
                dice.under = dice.down;
                dice.down = temp;

                if(map[nx][location.y] == 0) map[nx][location.y] = dice.under;
                else{
                    dice.under = map[nx][location.y];
                    map[nx][location.y] = 0;
                }

                System.out.println(dice.top);
            }
        }
    }
}
