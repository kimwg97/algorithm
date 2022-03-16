package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N13335 {
    public void N13335(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int w = sc.nextInt();
        int[] truck = new int[n];

        for(int i = 0; i < n; i++) truck[i] = sc.nextInt();

        int count = 0;
        int sum = 0;
        int i = 0;
        Queue<Integer> q = new LinkedList<>();

        while(true){
            int t = 0;

            if(i == n){
                count += l;
                break;
            }
            else t = truck[i];

            if(q.size() == l) sum -= q.poll();

            if(sum + t <= w){
                q.add(t);
                sum += t;
                if(i < n) i++;
            } else q.add(0);

            count++;
//            for(int j : q){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//            System.out.println(sum + " " + count);
        }
        System.out.println(count);
    }
}
