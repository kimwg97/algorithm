package Baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class N1987 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int r, c, max;
    HashMap<Character, Integer> map = new HashMap<>();

    public void N1987(){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        max = 0;
        char[][] board = new char[r][c];

        int j = 0;
        for(int i = 0; i < r; i++){
            String cc = sc.next();
            j=0;
            for(char x : cc.toCharArray()){
                board[i][j] = x;
                j++;
            }
        }

        DFS(board, 0, 0, 0);
        System.out.println(max);

    }

    // 4방향 탐색한다 -> DFS 다음 방향 넘겨줌
    // 현재 칸 알파뱃을 맵에 저장
    // 다음 칸 알파뱃이 맵에 존재하는지 확인
    // 없으면 else 진행, count + 1 해줘야지
    // 있으면 if 걸리고 count 리턴

    public void DFS(char[][] board, int x, int y, int count){
        if(map.get(board[y][x]) != null){
            max = Math.max(count, max);
            return;
        }else{
            for(int i = 0; i < 4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx >= 0 && my >= 0 && mx < c && my < r){
                    map.put(board[y][x], 1);
                    DFS(board, mx, my, count+1);
                    map.remove(board[y][x]);
                }
            }
        }
    }
}
