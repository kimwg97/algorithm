package Baekjoon;

import java.util.Scanner;

public class N17141 {
    int n, m;
    int[][] map;
    int[][] brick;
    int count = 0;
    int max = Integer.MIN_VALUE;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public void N17141(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        brick = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) brick[i][j] = 1;
            }
        }


    }

    public void virus(){

    }

    public void DFS(int l){
        if(l == m){
            virus();
        }else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 2){
                        map[i][j] = 3;              // 바이러스 자리로 취급
                        DFS(l+1);
                        map[i][j] = 2;              // 다시 바이러스 자리 후보로
                    }
                }
            }
        }
    }
}
