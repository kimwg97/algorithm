package Baekjoon;

import java.util.Scanner;

public class N14889 {
    int[][] arr;
    int n;
    int min = Integer.MAX_VALUE;
    int sum;

    public void N14889(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
                sum += arr[i][j];
            }
        }

        DFS(0, 0);
    }
    
    // 팀 더하는 기준을 찾아오셈

    public void DFS(int l, int sTeam){
        if(l == n/2){
            int gap = sum - sTeam;
            min = Math.min(min, gap);
        }else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    DFS(l+1, sTeam+arr[i][j]);
                }
            }

        }
    }
}
