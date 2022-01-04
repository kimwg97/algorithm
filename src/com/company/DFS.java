package com.company;

public class DFS {
    public void dfs(int l, int[] arr){      // 모든 부분 집합 구하기, l = 0, arr 은 연속된 자연수
        if(l == arr.length){
            for(int i = 0; i < arr.length; i++)
                if(arr[i] == 1) System.out.print(i+1 + " ");
            System.out.println();
        }
        else{
            arr[l] = 1;
            dfs(l+1, arr);
            arr[l] = 0;
            dfs(l+1, arr);
        }
    }
}
