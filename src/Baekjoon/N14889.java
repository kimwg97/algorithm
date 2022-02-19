package Baekjoon;

import java.util.Scanner;

public class N14889 {
    int[][] arr;
    int[] check;
    int[] team;
    int n;
    int min = Integer.MAX_VALUE;
    int sum = 0;

    public void N14889(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        check = new int[2];
        team = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
        }

        DFS(0, 0);
        System.out.println(min);
    }


    // 한번 더하고 다음에 더할 때도 생각해야함, 지금처럼이면 다음에 못 더할듯?

    public void synergy(int t, int l, int c){
        if(l == 2){
            sum += arr[check[0]][check[1]] + arr[check[1]][check[0]];
        }else{
            for(int i = c; i < n; i++){
                if(team[i] == t){
                    if(check[l] == 0) {
                        check[l] = i;
                        synergy(t, l+1, i+1);
                        check[l] = 0;
                    }
                }
            }
        }
    }

    public void DFS(int l, int c){
        if(l == n/2){
            synergy(1, 0, 0);
            int smile = sum;
            sum = 0;

            synergy(0, 0, 0);
            int link = sum;
            sum = 0;

            int gap = Math.abs(smile - link);
            min = Math.min(min, gap);
        }else{
            for(int i = c; i < n; i++){
                if(team[i] == 0){
                    team[i] = 1;
                    DFS(l+1, i+1);
                    team[i] = 0;
                }
            }
        }
    }
}
