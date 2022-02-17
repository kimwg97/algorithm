package Baekjoon;

import com.company.DFS;

import java.util.Scanner;

public class N9663 {
    int count = 0;
    int n;
    int[] board;

    public void N9663(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        DFS(0);

        System.out.println(count);
    }

    public void DFS(int v){
        if(v == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            board[v] = i;
            if(Check(v)){
                DFS(v+1);
            }
        }

    }

    public boolean Check(int y){                        // y는 퀸의 개수이자 열임. y 열 행 값이 다른 행값과 같으면 탈락, 열 값은 이미 나줘지도록 설정됨
        for(int i = 0; i < y; i++){
            if(board[i] == board[y]) return false;
            else if(Math.abs(i - y) == Math.abs(board[i] - board[y])) return false;
        }

        return true;
    }
}
