package com.company;

import java.util.Scanner;

public class Bubble {
    public void sort(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int h = 0; h < n; h++) list[h] = sc.nextInt();
        int temp;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1; j++) if(list[j] > list[j + 1]) swap(list, j);
        }
        for(int k = 0; k < n; k++) System.out.print(list[k] + " ");
    }
    public void swap(int[] list, int j){
        int temp = list[j+1];
        list[j+1] = list[j];
        list[j] = temp;
    }
}
