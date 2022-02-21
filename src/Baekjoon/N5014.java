package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N5014 {
    int f, s, g, u, d;
    int[] floor;

    public void N5014() {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        floor = new int[f + 1];

        BFS(s);
        if (floor[g] == 0) System.out.println("use the stairs");
    }

    public void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        floor[start] = 1;

        Loop1:
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int now = q.poll();

                if (floor[g] > 0) {
                    System.out.println(floor[g] - 1);
                    break Loop1;
                }

                int uNow = now + u;
                if (uNow <= f && floor[uNow] == 0) {
                    floor[uNow] = floor[now] + 1;
                    q.offer(uNow);
                }

                int dNow = now - d;
                if (dNow > 0 && floor[dNow] == 0) {
                    floor[dNow] = floor[now] + 1;
                    q.offer(dNow);
                }
            }
        }
    }
}
