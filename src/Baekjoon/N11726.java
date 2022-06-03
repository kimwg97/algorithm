package Baekjoon;

import java.util.Scanner;

public class N11726 {

    int n;
    int[] dp;
    public void N11726(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            if(i == 1) dp[i] = 1;
            else if(i == 2) dp[i] = 2;
            else dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
