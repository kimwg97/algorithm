package Baekjoon;

import java.util.Scanner;

public class N11053 {

    int n;
    int[] arr;
    int[] dp;

    public void N11053(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];                                          // 자신과 자기보다 뒤에 있고 작은 수의 개수를 저장할 dy 배열

        dp[0] = 1;                                                      // 첫 번째 수는 무조건 증가 값이 자신을 포함한 1개이므로 1로 초기화

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Lsi();
    }

    public void Lsi(){                                                  // 최장증가수열 알고리즘, 주어진 수열에서 가장 길게 증가하는 숫자의 개수를 알아낸다
        // 자기보다 작은 수의 개수를 저장하는 방식으로, 먼저 구한 값의 증가수에 +1 하면 현재 값의 증가수를 구할 수 있다
        for(int j = 1; j < n; j++){
            int temp = arr[j];                                          // j는 현재 비교할 값
            for(int k = j-1; k >= 0; k--){                              // 현재 값보다 뒤에 값들 중 작은 값들을 추리기 위해 j부터 0까지 진행
                if(temp > arr[k] && dp[j] < dp[k]) dp[j] = dp[k];       // 현재값보다 작고 dy 저장된 값은 크다면(증가 수가 많다면) 그 값을 현재 dy에 저장한다
            }
            dp[j]++;                                                    // 자기보다 작은 수의 증가수만큼을 저장했으니, 자신을 포함해 +1을 해준다
        }
        int max = 0;
        for(int h = 0; h < n; h++) max = Math.max(max, dp[h]);
        System.out.println(max);
    }
}
