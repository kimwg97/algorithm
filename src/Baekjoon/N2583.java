package Baekjoon;

import java.util.Scanner;

public class N2583 {
    public void Solution(){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt()+1;
        int n = sc.nextInt()+1;
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
                    if(j >= ly && j <= ry && h >= lx && h <= rx && board[j][h] != 1) board[j][h] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) System.out.print(board[i][j] + " ");
            System.out.println();
        }

    }
}
