package com.company;

public class DFS {
    int count = 0;
    int max = 0;
    int min = 10000;

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

    public int dfs2(int[] arr, int n, int c, int l){ // 제한된 양 c에서 최대 합 구하기
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

    public void dfs3(int[] arr, int m, int coin, int sum){ // 동전 개수 최솟값 구하기
        if(sum > m) return;                                 // 합친 값이 기준치를 넘어가면 필요없으므로 다시 리턴시킴(이 트리는 여기서 넘긴다)
        if(min < coin) return;                              // 기존 코인 수가 현재 코인 수보다 적다면 이 트리도 더 이상 구할 필요없으므로 리턴
        if(sum == m){                                       // 기준치와 동전합이 같다면
            if(min > coin) min = coin;                      // 기존 코인 수보다 현재 코인 수가 작으면 min 값을 바꿈
        }else {
            for(int i = arr.length-1; i >= 0; i--){         // 높은 가격의 동전부터 시작하고 현재 사용한 동전을 재귀를 통해 다시한 번 사용할 수 있게 한다
                dfs3(arr, m, coin+1, sum+arr[i]); // 코인이 다음 레벨이고 동전을 합한 가격을 넘겨준다
            }
        }
    }

    public int dfs4(int[][] arr, int n, int r){ // DFS 를 이용한 조합의 개수 구하기
        if(arr[n][r] > 0) return arr[n][r];     // 이미 값을 구한 경우
        if(n==r || r==0) return 1;              // n==r 이면 n개중 r개를 구하는 것이고, r==0이면 공집합뿐이므로 1이다
        else return arr[n][r] = dfs4(arr, n-1, r-1) + dfs4(arr, n-1, r);
    }

    public void dfs5(int[] arr, int n, int c, int l){ // DFS 를 이용한 조합 구하기
        if(l==arr.length){                                  // 구하려는 조합 개수까지 왔다면, 즉 레벨이 마지막으로 오면
            for(int x : arr) System.out.print(x + " ");     // 구해진 조합 값들을 출력
            System.out.println();
        }else{
            for(int i = c; i <= n; i++){                    // c는 i의 시작점을 의미하며 주어진 n 까지의 조합을 만들 때 사용된다
                arr[l] = i;                                 // 조합에 현재 i값을 넣어준다
                dfs5(arr, n, i+1, l+1);               // c에 i+1 값을 넘겨서 조합의 수가 겹치지 않고 다음으로 넘어간다
            }
        }
    }

}
