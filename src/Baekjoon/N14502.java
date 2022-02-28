package Baekjoon;

import java.util.Scanner;

public class N14502 {
    int n, m;
    int[][] map;
    int[][] check;
    int[][] vir;
    int count = 0;
    int max = Integer.MIN_VALUE;

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

        System.out.println(max);
    }

    public void virus(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && ny >= 0 && ny < m && nx < n && vir[nx][ny] == 0){
                vir[nx][ny] = 3;
                virus(nx, ny);
            }
        }
    }

    public void DFS(int x, int y, int l){
        if(l == 3){
            // 벽이 세개 세워지면 해당 배열을 클론하여 2를 3으로 감염시킴
            vir = check.clone();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(vir[i][j] == 2) {
                        vir[i][j] = 3;
                        virus(i, j);
                    }
                }
            }

            // 안전 지역 0을 세는 부분
            System.out.println("vir: ");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(vir[i][j] + " ");
                    if(vir[i][j] == 0) count++;
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("check: ");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++) System.out.print(check[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            max = Math.max(max, count);
            count = 0;
        }else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(check[i][j] == 0){
                        check[i][j] = 4;
                        DFS(i, j, l+1);
                        check[i][j] = 0;
                    }
                }
            }

        }
    }
}
