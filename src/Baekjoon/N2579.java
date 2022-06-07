package Baekjoon;

import java.util.Scanner;

public class N2579 {

    int n;
    int[] stairs;
    int[] dp;

    public void N2579(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        stairs = new int[301];
        dp = new int[301];

        for(int i = 1; i <= n; i++) stairs[i] = sc.nextInt();

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[3] + stairs[1], stairs[3] + stairs[2]);

        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];

//            System.out.println(dp[i]);
        }


//        System.out.println();
        System.out.println(dp[n]);
    }
}
