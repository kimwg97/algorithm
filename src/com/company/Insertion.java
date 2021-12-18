package com.company;

import java.util.Scanner;

public class Insertion {
    public void sort(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int  h = 0; h < n; h++) list[h] = sc.nextInt();
        int temp;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i; j >= 0; j--) if(list[j+1] < list[j]) swap(list, j);
        }
        for(int k = 0; k < n; k++) System.out.print(list[k] + " ");
    }
    public void swap(int[] list, int j){
        int temp = list[j+1];
        list[j+1] = list[j];
        list[j] = temp;
    }
}
