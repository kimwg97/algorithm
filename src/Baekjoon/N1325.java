package Baekjoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class N1325 {

    int n, m;
    int[] dp;
    int[][] computer;
    ArrayList<Integer> best = new ArrayList<>();

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void N1325(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[n+1];
        dp[1] = 1;
        computer = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            computer[b][a] = 1;
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            DFS(i);
            max = Math.max(max, dp[i]);
        }

        for(int i = 1; i <= n; i++){
            if(dp[i] == max) best.add(i);
        }

        Collections.sort(best);

        for(int i : best){
            System.out.println(i);
        }

    }

    public int DFS(int c){

        if(dp[c] != 0 ) return dp[c];
        else {
            for (int i = 1; i <= n; i++) {
                if (computer[c][i] == 1) {
                    dp[c] += DFS(i) + 1;
                }
            }
        }

        return dp[c];
    }
}
