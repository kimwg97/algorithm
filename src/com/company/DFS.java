package com.company;

public class DFS {
    int count = 0;
    int max = 0;

    public void dfs1(int l, int[] arr){      // 모든 부분 집합 구하기, l = 0, arr 은 연속된 자연수
        if(l == arr.length){
            for(int i = 0; i < arr.length; i++)
                if(arr[i] == 1) System.out.print(i+1 + " ");
            System.out.println();
        }
        else{
            arr[l] = 1;
            dfs1(l+1, arr);
            arr[l] = 0;
            dfs1(l+1, arr);
        }
    }

    public int dfs2(int[] arr, int n, int c, int l){
        if(l == n){
            if(count > c) return count;
            if(max < count) max = count;
            System.out.println(count);
        }else{
            count += arr[l];
            dfs2(arr, n, c,l+1);
            count -= arr[l];
            dfs2(arr, n, c, l+1);
        }
        return max;
    }
}
