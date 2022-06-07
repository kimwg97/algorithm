package Baekjoon;

import java.util.Scanner;

public class N1149 {

    int n;
    int[][] col;
    int[][] dp;

    public void N1149(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n][3];
        dp = new int[n][3];

        for(int i = 0; i < n; i++){
            col[i][0] = sc.nextInt();
            col[i][1] = sc.nextInt();
            col[i][2] = sc.nextInt();
        }

        dp[0][0] = col[0][0];
        dp[0][1] = col[0][1];
        dp[0][2] = col[0][2];

//        System.out.println(dp[0][0] + " " + dp[0][1] + " " + dp[0][2]);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][0] = Math.min(col[i][0] + dp[i-1][1], col[i][0] + dp[i-1][2]);
                }
                else if(j == 1){
                    dp[i][1] = Math.min(col[i][1] + dp[i-1][0], col[i][1] + dp[i-1][2]);
                }
                else{
                    dp[i][2] = Math.min(col[i][2] + dp[i-1][0], col[i][2] + dp[i-1][1]);
                }
            }
//            System.out.println(dp[i][0] + " " + dp[i][1] + " " + dp[i][2]);
        }


        int min = Math.min(dp[n-1][0], dp[n-1][1]);
        min = Math.min(min, dp[n-1][2]);

//        System.out.println(dp[n-1][0] + " " + dp[n-1][1] + " " + dp[n-1][2]);
        System.out.println(min);

    }
}
