package Baekjoon;

import java.util.Scanner;

public class N17090 {
    int n, m;
    char[][] map;
    int check[][];

    public void N17090(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        check = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j = 0; j < m; j++) map[i][j] = str.charAt(j);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(check[i][j] == 0){
                    int result = DFS(i, j);
//                    System.out.println(i + ", " + j + " : " + result);
                    if(result == -1) check[i][j] = -1;
                    else if(result == 2) check[i][j] = 2;
                }
            }
        }
//        System.out.println();
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++) System.out.print(check[i][j] + " ");
//            System.out.println();
//        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(check[i][j] == 2) count++;
            }
        }
        System.out.println(count);
    }

    public int DFS(int r, int c){

        if(check[r][c] == 1){
            check[r][c] = -1;
            return -1;
        }

        if(check[r][c] == 2) return 2;

        if(map[r][c] == 'D'){
            check[r][c] = 1;
            if(r+1 < n) return check[r+1][c] = DFS(r+1, c);
            else return 2;
        }
        else if(map[r][c] == 'U'){
            check[r][c] = 1;
            if(r-1 >= 0) return check[r-1][c] = DFS(r-1, c);
            else return 2;
        }
        else if(map[r][c] == 'L'){
            check[r][c] = 1;
            if(c-1 >= 0) return check[r][c-1] = DFS(r, c-1);
            else return 2;
        }
        else{
            check[r][c] = 1;
            if(c+1 < m) return check[r][c+1] = DFS(r, c+1);
            else return 2;
        }

    }
}
