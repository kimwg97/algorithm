package Baekjoon;

import java.util.Scanner;

public class N9466 {

    int n;
    int[] arr;
    int[] team;

    public void N9466(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            n = sc.nextInt();
            arr = new int[n+1];
            team = new int[n+1];

            for(int j = 1; j <= n; j++) arr[j] = sc.nextInt();

            for(int j = 1; j <= n; j++) if(team[j] == 0) DFS(j);


            int sum = 0;
            for(int j = 1; j <= n; j++) {
//                System.out.print(team[j] + " ");
                if(team[j] == -1) sum++;
            }

            System.out.println(sum);
        }
    }

    public int DFS(int x){
        if(team[x] == -1) return 0;

        else if(team[x] == 1) team[x] = 2;

        else if(team[x] == 2) return 0;

        else team[x] = 1;

        DFS(arr[x]);
        if(team[x] == 1) team[x] = -1;
        return 0;
    }

}
