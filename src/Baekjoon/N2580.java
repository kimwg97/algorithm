package Baekjoon;

import java.awt.*;
import java.util.Scanner;

public class N2580 {
    int[][] board;
    public void N2580() {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];
        int[] check = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) board[i][j] = sc.nextInt();
        }
        DFS(0, 0);

    }

    public void DFS(int x, int y){
        if(y == 9){
            DFS(x+1, 0);
            return;
        }

        if(x == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++) System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.exit(0);
        }

        if(board[y][x] == 0){
            for(int i = 1; i <= 9; i++){
                if(Check(x, y, i)){
                    board[y][x] = i;
                    DFS(x, y+1);
                }
            }
            board[y][x] = 0;
            return;
        }

        DFS(x, y+1);
    }

    public boolean Check(int x, int y, int v){
        int startX = (x/3) * 3;
        int startY = (y/3) * 3;

        for(int i = 0; i < 9; i++){
            if(board[y][i] == v) return false;
        }

        for(int i = 0; i < 9; i++){
            if(board[i][x] == v) return false;
        }

        for(int i = startY; i < startY+3; i++){
            for(int j = startX; j < startX+3; j++){
                if(board[i][j] == v) return false;
            }
        }
        return true;
    }
}
