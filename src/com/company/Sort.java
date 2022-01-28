package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Sort {
    public void Bubble(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int h = 0; h < n; h++) list[h] = sc.nextInt();
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1; j++) if(list[j] > list[j + 1]) swap(list, j);
        }
        for(int k = 0; k < n; k++) System.out.print(list[k] + " ");
    }

    public void Insertion(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int  h = 0; h < n; h++) list[h] = sc.nextInt();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i; j >= 0; j--) if(list[j+1] < list[j]) swap(list, j);
        }
        for(int k = 0; k < n; k++) System.out.print(list[k] + " ");
    }

    public void Selection(){
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
            selectionSwap(list, i, minN);
        }
        for(int k = 0; k < list.length; k++) System.out.print(list[k] + " ");
    }

    public void LRU(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] list = new int[n];
        ArrayList cache = new ArrayList();

        for(int h = 0; h < n; h++) list[h] = sc.nextInt();

        for(int i = 0; i < n; i++){
            if(cache.size() < s) {
                if(cache.contains(list[i])) cache.remove(Integer.valueOf(list[i]));
            }else{
                if(!cache.contains(list[i])) cache.remove(s-1);
                else cache.remove(Integer.valueOf(list[i]));
            }
            cache.add(0, list[i]);
        }
        for(int j = 0; j < s; j++) System.out.print(cache.get(j) + " ");
    }

    public void selectionSwap(int[] list, int i, int minN){
        int temp = list[i];
        list[i] = list[minN];
        list[minN] = temp;
    }

    public void swap(int[] list, int j){
        int temp = list[j+1];
        list[j+1] = list[j];
        list[j] = temp;
    }
}
