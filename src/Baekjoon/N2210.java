package Baekjoon;

import java.util.Scanner;

public class N2210 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    boolean[][] check = new boolean[5][5];
    int[][] board = new int[5][5];
    int[] jump;
    int count = 0;

    public void N2210(){
        Scanner sc = new Scanner(System.in);
        jump = new int[1000000];

        for(int i = 0; i< 5; i++){
            for(int j = 0; j < 5; j++) board[i][j] = sc.nextInt();
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                DFS(10, board[i][j], i, j);
            }
        }

        System.out.println(count);
    }

    public void DFS(int l, int n, int x, int y){
        if(l == 1000000){
            if(jump[n] == 0){
                jump[n] = 1;
                count++;
            }
            return;
        }else{
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                    int next = board[nx][ny]*l + n;
                    DFS(l*10, next, nx, ny);
                }
            }
        }
    }

}
