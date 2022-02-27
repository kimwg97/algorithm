package Baekjoon;

import java.util.Scanner;

public class N14502 {
    int n, m;
    int[][] map;
    int[][] check;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public void N14502(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) map[i][j] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    check = map.clone();
                    DFS(i, j, 0);
                }
            }
        }

    }

    public void virus(){

    }

    // 위에서 for 문으로 DFS 호출
    // 벽은 무조건 세개 세워야 하므로 먼저 세개 세우고
    // 세개 다 세웠으면 2로 채우고(다른 함수)
    // 0개수 세고
    // 백트래킹 하면서 다른 곳에 벽을 세워가면서 반복
    public void DFS(int x, int y, int l){
        if(l == 3){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++) System.out.print(check[i][j]);
                System.out.println();
            }
            System.out.println();
            return;
        }else{
            for(int i = x; i < n; i++){
                for(int j = y; j < m; j++){
                    for(int h = 0; h < 4; h++) {
                        if(check[i][j] == 0){
                            check[i][j] = 3;
                            DFS(i, j, l+1);
                            check[i][j] = 0;
                        }
                    }
                }
            }

        }
    }
}
