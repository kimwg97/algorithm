package com.company;

import java.util.Scanner;

public class DP {
    int[] arr;

    public void lsi(){
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
}
