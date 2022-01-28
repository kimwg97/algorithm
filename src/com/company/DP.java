package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DP {
    int[] arr;

    public void Lsi(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] dy = new int[n];
        dy[0] = 1;

        for(int j = 1; j < n; j++){
            int temp = arr[j];
            for(int k = j-1; k >= 0; k--){
                if(temp > arr[k] && dy[j] < dy[k]) dy[j] = dy[k];
            }
            dy[j]++;
        }
        int max = 0;
        for(int h = 0; h < n; h++) max = Math.max(max, dy[h]);
        System.out.println(max);
    }

    public void Coin(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j <= m; j++){
                int temp = dy[j - arr[i]] + 1;
                if(dy[j] > temp) dy[j]  = temp;
            }
        }
        System.out.println(dy[m]);
    }
}
