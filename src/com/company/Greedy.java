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


    public int Kruskal(ArrayList<kEdge> p){          // 간선 중심으로 최소 경로를 찾는 알고리즘
        int sum = 0;
        for(kEdge i : p){                                   // 그래프는 간선의 cost 값을 오름차순으로 하여 정렬되어 있음
            int a = i.a;
            int b = i.b;
            if(Find(a) != Find(b)) {                        // 간선의 노드끼리 Find 값이 다르다면 사이클이 아님을 의미
                Union(a, b);                                // 해당 간선은 Union 하여 사이클을 방지하고
                sum += i.cost;                              // 해당 간선의 cost 값은 사이클이 아닌 최소값이므로 더해준다
            }
        }
        return sum;
    }

    public void KruskalInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<kEdge> p = new ArrayList<>();

        arr = new int[n+1];
        for(int j = 1; j <= n; j++) arr[j] = j;

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            p.add(new kEdge(a, b, c));                                          // a는 현재 노드, b는 이동 노드, c는 가중치
        }
        Collections.sort(p);                                                    // c값이 작은 것부터 나오도록 정렬
        int sum = Kruskal(p);
        System.out.println(sum);
    }


    //-------------------------------------------Prim-------------------------------------------------------------

    public int Prim(int v){                                         // 크루스칼과는 다르게 노드 중심으로 최소 경로를 찾는다
        int sum = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(v, 0));

        while(!q.isEmpty()){                                        // 다익스트라와 비슷한 방법을 이용
            Edge now = q.poll();
            int nowVex = now.vex;
            int nowCost = now.cost;
            if(arr[nowVex] == 0){                                   // 해당 배열을 지나갔다면 1, 아니라면 0을 의미
                arr[nowVex] = 1;                                    // 해당 노드를 지나가면 인덱스 값을 1로 바꿔준다
                sum += nowCost;
                for( Edge od : graph.get(nowVex)){
                    if(arr[od.vex] == 0) q.offer(new Edge(od.vex, od.cost));        // 다음으로 찾을 노드 값이 0, 즉 지나가지 않았다면 큐에 넣어서 확인한다
                }
            }
        }
        return sum;
    }

    public void PrimInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n+1];                                                     // 해당 노드를 지나갔는지 확인하기 위한 배열, 프림이 노드 중심으로 돌아가게 해줌

        graph = new ArrayList<>();
        for(int j = 0; j < m; j++) graph.add(new ArrayList<>());                // 다익스트라와 같은 방법으로 그래프를 만들어준다

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));                                   // 다익스트라와는 다르게 양방향으로 움직일 수 있으므로 두가지 경우를 add 해준다
        }

        int sum = Prim(1);
        System.out.println(sum);
    }

}
