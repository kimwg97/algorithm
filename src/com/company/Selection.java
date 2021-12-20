package com.company;

import java.util.Scanner;

public class Selection {
    public void sort(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int h = 0 ; h < list.length; h++) list[h] = sc.nextInt();
        for(int i = 0; i < list.length; i++){
            int min = list[i];
            int minN = i;
            for(int j = i+1; j < list.length; j++){
                if(list[j] < min) {
                    min = list[j];
                    minN = j;
                }
            }
            swap(list, i, minN);
        }
        for(int k = 0; k < list.length; k++) System.out.print(list[k] + " ");
    }
    public void swap(int[] list, int i, int minN){
        int temp = list[i];
        list[i] = list[minN];
        list[minN] = temp;
    }
}
