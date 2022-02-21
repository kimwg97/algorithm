package Baekjoon;

import java.util.Scanner;

public class N15684 {
    int n, m, h;
    int[][] arr;

    public void N15684(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        arr = new int[h+1][n+1];

        for(int i = 0; i < m; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
    }

    public void DFS(){
        
    }
}
