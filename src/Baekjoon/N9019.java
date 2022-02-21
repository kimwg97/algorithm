package Baekjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N9019 {
    int[][] testCase;
    boolean[] check;
    int t;

    public class TCase{
        int num;
        String calculate;

        public TCase(int num, String calculate){
            this.num = num;
            this.calculate = calculate;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
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
        check = new boolean[10000];

        Loop1 :
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TCase n = q.poll();

                if(n.num == result) System.out.println(n.calculate);

                int d = n.D();
                if(!check[d]) {
                    check[d] = true;
                    q.offer(new TCase(d, n.calculate+"D"));
                }

                int s = n.S();
                if(!check[s]) {
                    check[s] = true;
                    q.offer(new TCase(s, n.calculate + "S"));
                }

                int l = n.L();
                if(!check[l]) {
                    check[l] = true;
                    q.offer(new TCase(l, n.calculate + "L"));
                }

                int r = n.R();
                if(!check[r]) {
                    check[r] = true;
                    q.offer(new TCase(r, n.calculate + "R"));
                }

            }
        }
    }



}
