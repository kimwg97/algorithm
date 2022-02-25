package Baekjoon;

import java.util.*;

public class N13913 {

    int[] count;
    int[] check;
    public void N13913(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        check = new int[100001];
        count = new int[100001];

        BFS(n, k);

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int bef = k;

        int time = count[k] - 1;
        for(int i = 0; i < time; i++){
            bef = check[bef];
            stack.push(bef);
        }

        System.out.println(time);
        for(int i = 0; i <= time; i++){
            System.out.print(stack.pop() + " ");
        }

    }

    public void BFS(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        count[n] = 1;

        while (!q.isEmpty()){
            int temp = q.poll();
            for(int i = 0; i < 3; i++){

                if(temp == k) return;

                int next;
                if(i == 0) next = temp + 1;
                else if(i == 1) next = temp - 1;
                else next = temp * 2;

                if(next < 0 || next > 100000) continue;
                if(count[next] == 0){
                    count[next] = count[temp] + 1;
                    check[next] = temp;
                    q.add(next);
                }
            }
        }
    }
}
