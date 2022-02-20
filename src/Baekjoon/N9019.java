package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N9019 {
    int[][] testCase;
    int t;

    public void N9019(){
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        testCase = new int[t][2];

        for(int i = 0; i < t; i++){
            testCase[i][0] = sc.nextInt();
            testCase[i][1] = sc.nextInt();
        }

        for(int i = 0; i < t; i++){
            BFS(testCase[i][0], testCase[i][1]);
        }
    }

    public void BFS(int start, int result){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){

            }
        }
    }

}
