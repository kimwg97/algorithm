package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Sort {

    public void Quick(int[] arr){
        QuickSort(arr, 0, arr.length-1);
    }
    // 맨 왼쪽을 pivot 으로 설정한 QuickSort
    public void QuickSort(int[] arr, int lo, int hi){           // 배열의 pivot 을 Partition 함수로 결정하고 lo >= hi, 즉 배열의 크기가 1일 때까지 재귀를 돌려준다
        if(lo >= hi) return;
        int pivot = PartitionMid(arr, lo, hi);
        QuickSort(arr, lo, pivot-1);                        
        QuickSort(arr, pivot, hi);                              // pivot 값을 중간으로 둘 경우 partition 한 값에 pivot 까지 포함해야한다. 아니라면 +1 을하여 pivot 값은 제외한다
    }

    public int PartitionLeft(int[] arr, int left, int right){       // pivot(가장 왼쪽 원소)를 기준으로 받아온 배열의 원소를 큰 수는 오른 쪽, 작은 수는 왼쪽으로 바꿔준다
        int lo = left;
        int hi = right;
        int pivot = arr[left];

        while(lo < hi){                                         // lo와 hi가 교차할 때까지 진행
            while(pivot < arr[hi] && lo < hi) hi--;             // 오른쪽 원소가 pivot 보다 크다면 다음 원소로 넘어간다
            while(pivot >= arr[lo] && lo < hi) lo++;            // 왼쪽 원소가  pivot 보다 작거나 같다면 다음 원소로 넘어간다
            swap(arr, hi, lo);                         // 위 조건에 걸리지 않으면, 즉 오른쪽에서 pivot 보다 작고 왼쪽에서 pivot 보다 큰 hi와 lo를 swap 한다
        }

        swap(arr, left, lo);
        return lo;
    }

    public int PartitionRight(int[] arr, int left, int right){
        int lo = left;
        int hi = right;
        int pivot = arr[right];

        while(lo < hi){
            while (arr[hi] >= pivot && lo < hi) hi--;
            while (arr[lo] < pivot && lo < hi) lo++;
            swap(arr, hi, lo);
        }

        swap(arr, right, hi);
        return hi;
    }

    public int PartitionMid(int[] arr, int lo, int hi){
        int pivot = arr[(lo + hi) / 2];
        while (lo <= hi) {
            while (arr[hi] > pivot) hi--;
            while (arr[lo] < pivot) lo++;
            if (lo <= hi) {
                swap(arr, lo, hi);
                lo++;
                hi--;
            }
        }
        return lo;
    }

    public void Merge(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Divide(arr, res, 0, n-1);
        for(int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }

    public void Divide(int[] arr, int[] res, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;

            Divide(arr, res, start, mid);
            Divide(arr, res, mid+1, end);

            Combine(arr, res, start, end, mid);
        }
    }

    public void Combine(int[] arr, int[] res, int start, int end, int mid){
        int i = start;
        int j = mid+1;
        int k = start;

        while (i <= mid && j <= end){
            if(arr[i] < arr[j]) res[k++] = arr[i++];
            else res[k++] = arr[j++];
        }
        if(j > end){
            for(int h = i; h <= mid; h++) res[k++] = arr[h];
        } else{
            for(int h = j; h <= end; h++) res[k++] = arr[h];
        }
        for(int h = start; h <= end; h++) arr[h] = res[h];

    }

    public void Bubble(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int h = 0; h < n; h++) list[h] = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++) if(list[j] > list[j + 1]) swap(list, j, j+1);
        }
        for(int k = 0; k < n; k++) System.out.print(list[k] + " ");
    }

    public void Insertion(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for(int  h = 0; h < n; h++) list[h] = sc.nextInt();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i; j >= 0; j--) if(list[j+1] < list[j]) swap(list, j, j+1);
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
            swap(list, i, minN);
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

    public void swap(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
