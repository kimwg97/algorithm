package Baekjoon;

import java.util.Scanner;

public class N9663 {
    public void N9663(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[8][8];
        int count = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 0){
                    count++;
                    Check(board, n);
                }
            }
        }
    }

    public void Check(int[][] board, int n){
        if(true){

        }else{

        }
    }
}
