package com.company;

import java.util.*;

public class Greedy {
    int[] arr;
    ArrayList<ArrayList<Edge>> graph;

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

    public class kEdge implements Comparable<kEdge>{
        int a;
        int b;
        int cost;
        public kEdge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        @Override
        public int compareTo(kEdge o) {
            return this.cost - o.cost;
        }
    }


    //-------------------------------------------Union&Find-------------------------------------------------------


    public int Find(int v){                     // 재귀 함수를 이용하여 찾는 값의 루트를 찾아간다 / 같은 루트를 갖는다면 같은 집합이라는 것을 의미한다
        if(arr[v] == v) return v;               // 인덱스와 그 값이 같다면 그 값은 루트이고 그것을 리턴
        else return arr[v] = Find(arr[v]);      // 배열 값을 자신의 루트로 초기화하여 불필요한 단계를 줄인다
    }

    public void Union(int fa, int fb){          // Find 함수를 이용하여 집합을 설정한다(입력 받은 값이 2개일 경우)
        int a = Find(fa);
        int b = Find(fb);
        if(a != b) arr[a] = b;                  // 찾은 두 값이 다르면 b를 a의 루트로 만든다
    }


//-----------------------------------------------Dijkstra---------------------------------------------------------


    public void Dijkstra(int v){
        PriorityQueue<Edge> q = new PriorityQueue<>();                          // 가중치가 작은 것부터 정렬되는 우선순위 큐를 생성
        q.offer(new Edge(v, 0));                                           // 시작 노드는 자기 자신에게 이동하는 가중치가 0이므로 시작점과 0을 입력
        while(!q.isEmpty()){
            Edge now = q.poll();
            int nowVex = now.vex;
            int nowCost = now.cost;
            if(arr[nowVex] < nowCost) continue;                                 // 이미 현재 저장된 가중치가 꺼내온 가중치보다 작다면 의미가 없으므로 넘긴다(큐 안에서 우선 순위에 밀려 나오지 못했던 값들 처리)
            for(Edge ob : graph.get(v)){                                        // 현재 노드에서 이동할 수 있는 노드와의 간선들을 꺼내온다
                if(nowCost + ob.cost < arr[ob.vex]){                            // 현재 노드까지 걸린 가중치 + 이동할 노드에 대한 가중치를 저장된 이동할 노드에 대한 가중치와 비교
                    arr[ob.vex] = nowCost + ob.cost;                            // 그 합이 더 작다면 그 값으로 가중치를 최신화
                    q.offer(new Edge(ob.vex, nowCost+ob.vex));             // 그리고 이동할 노드와 그 노드에 대한 가중치를 큐에 넣어 다시 비교
                }
            }
        }
    }

    public void DijkstraInput(){                                                // 다익스트라 알고리즘 그래프 입력 함수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();                                               // 시작 노드를 입력 받는다
        graph = new ArrayList<ArrayList<Edge>>();                               // 그래프는 Edge 리스트를 인덱스로 한 리스트
        for(int j = 0; j < n; j++) graph.add(new ArrayList<Edge>());            // 노드의 수 만큼 그래프에게 메모리 할당

        arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);                                    // 최소 가중치를 입력할 배열은 최댓값으로 초기화

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));                                   // a는 현재 노드, b는 이동 노드, c는 가중치
        }

        Dijkstra(start);                                                        // 그래프와 시작 노드를 다익스트라 알고리즘에 보낸다

        for(int h = 1; h <= arr.length; h++){
            if(arr[h] != Integer.MAX_VALUE) System.out.println(h + " : " + arr[h]);
            else System.out.println(h + " : impossible");                       // 값이 그대로 최댓값이면 시작 노드에서 갈 수 없음을 의미한다
        }

    }


    //-------------------------------------------Kruskal----------------------------------------------------------


    public int Kruskal(ArrayList<kEdge> p, int v){
        int sum = 0;
        for(kEdge i : p){
            int a = i.a;
            int b = i.b;
            if(Find(a) != Find(b)) {
                Union(a, b);
                sum += i.cost;
            }
        }
        return sum;
    }

    public void KruskalInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<kEdge> p = new ArrayList<>();
        for(int j = 0; j < n; j++) graph.add(new ArrayList<Edge>());            // 노드의 수 만큼 그래프에게 메모리 할당

        arr = new int[n+1];
        for(int j = 1; j <= n; j++) arr[j] = j;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            p.add(new kEdge(a, b, c));                                          // a는 현재 노드, b는 이동 노드, c는 가중치
            min = Math.min(min, c);
        }
        Collections.sort(p);
        int sum = Kruskal(p, min);
        System.out.println(sum);
    }

}
