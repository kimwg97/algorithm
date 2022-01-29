package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DP {                                           // 먼저 구한 값들을 근거로 다음 값을 구하는 알고리즘
    int[] arr;

    public class Question implements Comparable<Question>{
        int point;
        int time;

        public Question(int point, int time){
            this.point = point;
            this.time = time;
        }

        @Override
        public int compareTo(Question o) {
            return this.time - o.time;
        }
    }

    public void Lsi(){                                                  // 최장증가수열 알고리즘, 주어진 수열에서 가장 길게 증가하는 숫자의 개수를 알아낸다
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] dy = new int[n];                                          // 자신과 자기보다 뒤에 있고 작은 수의 개수를 저장할 dy 배열
        dy[0] = 1;                                                      // 첫 번째 수는 무조건 증가 값이 자신을 포함한 1개이므로 1로 초기화

        // 자기보다 작은 수의 개수를 저장하는 방식으로, 먼저 구한 값의 증가수에 +1 하면 현재 값의 증가수를 구할 수 있다
        for(int j = 1; j < n; j++){
            int temp = arr[j];                                          // j는 현재 비교할 값
            for(int k = j-1; k >= 0; k--){                              // 현재 값보다 뒤에 값들 중 작은 값들을 추리기 위해 j부터 0까지 진행
                if(temp > arr[k] && dy[j] < dy[k]) dy[j] = dy[k];       // 현재값보다 작고 dy 저장된 값은 크다면(증가 수가 많다면) 그 값을 현재 dy에 저장한다
            }
            dy[j]++;                                                    // 자기보다 작은 수의 증가수만큼을 저장했으니, 자신을 포함해 +1을 해준다
        }
        int max = 0;
        for(int h = 0; h < n; h++) max = Math.max(max, dy[h]);
        System.out.println(max);
    }

    public void Coin(){                                     // 동전 거스름돈 문제, DP 문제로 유명함
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] dy = new int[m+1];                            // 거스름돈 m원 까지, 각 원에서의 최소 동전 개수를 저장할 배열
        Arrays.fill(dy, Integer.MAX_VALUE);                 // 맨 처음에는 최댓값으로 초기화 해놓는다
        dy[0] = 0;                                          // 0원은 동전이 0개 필요하므로 0으로 초기화한다

        // j원 에서 사용하는 i원을 사용한 최소 동전 개수를 저장하고, 다음 값은 먼저 구한 동전 개수를 통해 최소 동전 개수를 알아간다.
        for(int i = 0; i < n; i++){                         // i는 동전의 종류를 의미
            for(int j = arr[i]; j <= m; j++){               // j는 돈을 의미, 동전 i원 부터 시작해서 m원 까지 진행한다
                int temp = dy[j - arr[i]] + 1;              // arr[i]를 빼는 것으로 j원 에서 현재 동전 값을 뺐을 때 구했던 최소 동전 개수를 알아내서 지금 i원을 쓴 동전 1개를 더한다
                if(dy[j] > temp) dy[j]  = temp;             // 만약 그 값이 원래 저장된 dy 값보다 작다면 해당 값으로 최신화 해준다
            }
        }
        System.out.println(dy[m]);
    }

    public void Knapsack(){                                 // 배낭 채우기 문제로 유명한 문제이다, 동전 문제와 유사
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m+1];
        ArrayList<Question> questions = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int q = sc.nextInt();
            int t = sc.nextInt();
            questions.add(new Question(q, t));
        }
        Collections.sort(questions);

        // 동전 문제와 같이 현재 i 시간에 j 시간을 사용할 때 최대 가치를 구하고, 먼저 구한 값들을 근거로 최대 가치 값을 구해간다
        for(int i = 0; i < n; i++){
            int temp = questions.get(i).time;
            for(int j = m; j >= temp; j--){                             // 동전 문제와는 반대로 j는 m부터 0까지 진행한다. 동전처럼 무한하지 않고 유한한 개수이기 때문이다
                int count = arr[j - temp] + questions.get(i).point;     // 구하는 방식은 동전 문제와 동일하게 j에서 현재 값을 뺏을 때 구했던 최대 가치에 현재 가치를 더해서 알아내는 방식이다
                if(count > arr[j]) arr[j] = count;
            }
        }
        System.out.println(arr[m]);
    }
}
