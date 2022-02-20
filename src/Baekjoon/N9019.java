package Baekjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N9019 {
    int[][] testCase;
    int t;

    public class TCase{
        int num;
        String calculate;

        public TCase(int num, String calculate){
            this.num = num;
            this.calculate = calculate;
        }
    }

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
        Queue<TCase> q = new LinkedList<>();
        q.offer(new TCase(start, ""));

        Loop1 :
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TCase n = q.poll();

                int d = D(n.num);
                q.offer(new TCase(d, n.calculate+"D"));
                if(d == result) {
                    System.out.println(n.calculate + "D");
                    break Loop1;
                }

                int s = S(n.num);
                q.offer(new TCase(s, n.calculate+"S"));
                if(s == result) {
                    System.out.println(n.calculate + "S");
                    break Loop1;
                }

                int l = L(n.num);
                q.offer(new TCase(l, n.calculate+"L"));
                if(l == result) {
                    System.out.println(n.calculate +"L");
                    break Loop1;
                }

                int r = R(n.num);
                q.offer(new TCase(r, n.calculate+"R"));
                if(r == result) {
                    System.out.println(n.calculate + "R");
                    break Loop1;
                }
            }
        }
    }

    public int D(int n){
        int result = n * 2;
        if(result > 9999) result = result % 10000;

        return result;
    }

    public int S(int n){
        int result = n - 1;
        if(result == 0) result = 9999;

        return result;
    }

    public int L(int n){
        int result = 0;

        result += n / 1000;
        result += (n % 1000) * 10;
        return result;
    }

    public int R(int n){
        int result = 0;

        result += (n % 10) * 1000;
        result += n / 10;
        return result;
    }

}
