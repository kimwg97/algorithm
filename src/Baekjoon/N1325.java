package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1325 {

    int n, m;
    int[] visit;
    int[] ans;
    ArrayList<Integer>[] computer;

    public void N1325(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ans = new int[n+1];
        computer = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) computer[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            computer[a].add(b);
        }

        int max = 0;

        for(int i = 1; i <= n; i++){
            visit = new int[n+1];
            BFS(i);
        }

        for(int i = 1; i <= n; i++) max = Math.max(max, ans[i]);

        for(int i = 1; i <= n; i++) if(ans[i] == max) System.out.print(i + " ");
    }

    public void BFS(int i)
    {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(i);
        visit[i] = 1;
        while (!q.isEmpty())
        {
            int temp = q.poll();
            for (int x : computer[temp])
            {
                if (visit[x] == 0)
                {
                    ans[x]++;
                    visit[x] = 1;
                    q.add(x);
                }
            }
        }
    }

    public void DFS(int c, int start){
        for(int x : computer[c]){
            if(visit[x] == 0){
                visit[x] = 1;
                ans[x]++;
                DFS(x, start);
            }
        }
    }
}
