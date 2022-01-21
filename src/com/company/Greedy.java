package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy {
    int[] arr;

    public class Edge implements Comparable<Edge>{
        int vex;
        int cost;
        public Edge(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public int Find(int v){
        if(arr[v] == v) return v;
        else return arr[v] = Find(arr[v]);
    }

    public void Union(int fa, int fb){
        int a = Find(fa);
        int b = Find(fb);
        if(a != b) arr[a] = b;
    }


//-----------------------------------------Dijkstra---------------------------------------------------------------


    public void Dijkstra(ArrayList<ArrayList<Edge>> graph, int v){
        PriorityQueue<Edge> q = new PriorityQueue<>();                          // 가중치가 작은 것부터 정렬되는 우선순위 큐를 생성
        q.offer(new Edge(v, 0));                                           // 시작점은 자기 자신에게 이동하는 가중치가 0이므로 시작점과 0을 입력
        while(!q.isEmpty()){
            Edge now = q.poll();
            int nowVex = now.vex;
            int nowCost = now.cost;
            if(arr[nowVex] < nowCost) continue;                                 // 이미 현재 저장된 가중치가 꺼내온 가중치보다 작다면 의미가 없으므로 넘긴다(큐 안에서 우선 순위에 밀려 나오지 못했던 값들 처리)
            for(Edge ob : graph.get(v)){                                        // 현재 점에서 이동할 수 있는 점들을 꺼내온다
                if(nowCost + ob.cost < arr[ob.vex]){                            // 현재 점까지 걸린 가중치 + 이동할 점에 대한 가중치를 저장된 이동할 점에 대한 가중치와 비교
                    arr[ob.vex] = nowCost + ob.cost;                            // 그 합이 더 작다면 그 값으로 가중치를 최신화
                    q.offer(new Edge(ob.vex, nowCost+ob.vex));             // 그리고 이동할 점과 그 점에 대한 가중치를 큐에 넣어 다시 비교
                }
            }
        }
    }

    public void DijkstraInput(){                                                // 다익스트라 알고리즘 그래프 입력 함수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();                                               // 시작점을 입력 받는다
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();    // 그래프는 Edge 리스트를 인덱스로 한 리스트
        for(int j = 0; j < n; j++) graph.add(new ArrayList<Edge>());            // 점의 수 만큼 그래프에게 메모리 할당

        arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);                                    // 최소 가중치를 입력할 배열은 최댓값으로 초기화

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));                                   // a는 현재 점, b는 이동점, c는 가중치
        }

        Dijkstra(graph, start);                                                 // 그래프와 시작점을 다익스트라 알고리즘에 보낸다

        for(int h = 1; h <= arr.length; h++){
            if(arr[h] != Integer.MAX_VALUE) System.out.println(h + " : " + arr[h]);
            else System.out.println(h + " : impossible");                       // 값이 그대로 최댓값이면 시작점에서 갈 수 없음을 의미한다
        }

    }


}
