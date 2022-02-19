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
        if(v == n){                     // 모든 퀸을 다 사용했다면
            count++;                    // 경우의 수 1을 늘리고
            return;                     // 그 전으로 백트래킹, 아래 돌고 있을 for 문으로 돌아가 다음 행을 따져준다
        }

        for(int i = 0; i < n; i++){     // 행을 대상으로 for 문을 돌림
            board[v] = i;               // 현재 함수가 보고 있는 v 열에 i 행이
            if(Check(v)){               // 다른 퀸과 공격이 겹치지 않는지 확인
                DFS(v+1);            // 겹치지 않는다면 다음 열로 넘겨준다
            }
        }

    }

    public boolean Check(int y){                        // y는 퀸의 개수이자 열임. y 열 행 값이 다른 행값과 같으면 탈락, 열 값은 이미 나줘지도록 설정됨
        for(int i = 0; i < y; i++){
            if(board[i] == board[y]) return false;      //
            else if(Math.abs(i - y) == Math.abs(board[i] - board[y])) return false;     // 대각선은 열 - 열 == 행 - 행 값이 같으면 같은 대각선에 있다는 것을 의미함
        }

        return true;
    }
}
