package Baekjoon;

import java.util.Scanner;

public class N1463 {

    int n;
    int[] dp;

    public void N1463(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];

        for(int i = 2; i <= n; i++){
            int a = dp[i-1] + 1;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            if(i % 2 == 0) b = dp[i / 2] + 1;
            if(i % 3 == 0) c = dp[i / 3] + 1;

            int d = Math.min(a, b);
            d = Math.min(d, c);

            dp[i] = d;
        }

        System.out.println(dp[n]);
    }
}
