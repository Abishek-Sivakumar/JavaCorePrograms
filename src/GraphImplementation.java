import java.util.*;

class Edge{
    int node;
    int weight;
    Edge(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

public class GraphImplementation {
    public static void PrimsAlgorithmMST(){
        int n = 4;
        int m = 5;
        Scanner sc = new Scanner(System.in);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }
        boolean visited[] = new boolean[n+1];
        List<int[]> ans = new ArrayList<>();
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->a[1]-b[1]);
        p.add(new int[]{0, 0, -1});
        int totalWeight = 0;
        while(!p.isEmpty()) {
            int current[] = p.poll();
            int node = current[0];
            int weight = current[1];
            int parent = current[2];
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            totalWeight+=weight;
            if(parent!=-1){
                ans.add(new int[]{parent, weight, node});
            }
            for(int edge[] : adj.get(node)){
                int neighbour = edge[0];
                int edgeWeight = edge[1];
                if(!visited[neighbour]){
                    p.add(new int[]{neighbour, edgeWeight, node});
                }
            }
        }
        System.out.println("The minimum spanning tree is ");
        for(int temp[] : ans){
            System.out.println(temp[0] + " " + temp[2] + " with weight " + temp[1]);
        }
    }

    //This is also the Prims Algorithm but with the custom Edge class and Integer.compare
    public static void findMST(int n, List<List<Edge>> adj){
        boolean visited[] = new boolean[n+1];
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));
        List<int[]> ans = new ArrayList<>();
        int totalCost = 0;
        p.add(new int[]{0,0,-1});
        while(!p.isEmpty()){
            int current[] = p.poll();
            int node = current[0];
            int weight = current[1];
            int parent = current[2];
            if(visited[node]){
                continue;
            }
            totalCost+=weight;
            visited[node] = true;
            if(parent!=-1){
                ans.add(new int[]{node, weight, parent});
            }
            for(Edge e : adj.get(node)){
                int neighbour = e.node;
                int nodeWeight = e.weight;
                if(!visited[neighbour]){
                    // visited[neighbour] = true;
                    p.add(new int[]{neighbour, nodeWeight, node});
                }
            }
        }
        System.out.println("Minimum Spanning Tree is ");
        for(int arr[] : ans){
            System.out.println(arr[2] + " -> " + arr[0] + " with weight " + arr[1]);
        }
        System.out.println("Total Cost : " + totalCost);
    }
    public static void bfs(int n, int startNode, List<List<Integer>> adj){
        boolean visited[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;
        System.out.println("BFS Traversal ");
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");
            for(int neighbour : adj.get(current)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        System.out.println();
    }
    public static void dfs(int n, int startNode, List<List<Integer>> adj){
//        int n = 4;
//        int m = 4;
//        Scanner sc = new Scanner(System.in);
//        List<List<Integer>> adj = new ArrayList<>();
//        for(int i=0;i<=n;i++){
//            adj.add(new ArrayList<>());
//        }
//        for(int i=0;i<m;i++){
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//        }
        boolean visited[] = new boolean[n+1];
        Stack<Integer> s = new Stack<>();
        s.push(startNode);
        System.out.println("DFS Traversal");
        while(!s.isEmpty()){
            int current = s.pop();
            if(!visited[current]){
                visited[current] = true;
                System.out.print(current+ " ");
                for(int neigbour : adj.get(current)){
                    if(!visited[neigbour]){
                        s.push(neigbour);
                    }
                }
            }
        }
        System.out.println();
    }
    public static void dfsUsingQueue(int n, int startNode, List<List<Integer>> adj){
        System.out.println("DFS Traversal");
        boolean visited[] = new boolean[n+1];
        Stack<Integer> s = new Stack<>();
        s.push(startNode);
        visited[startNode] = true;
        while(!s.isEmpty()){
            int node = s.pop();
            System.out.print(node + " ");
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    s.push(neighbour);
                }
            }
        }
    }
    public static boolean hasCycle(int n, List<List<Integer>> adj){
        boolean visited[] = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]){
                continue;
            }
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i, -1});
            visited[i] = true;
            while(!q.isEmpty()){
                int current[] = q.poll();
                int node = current[0];
                int parent = current[1];
                for(int neighbour : adj.get(node)){
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        q.add(new int[]{neighbour, node});
                    }else if(neighbour!=parent){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        Scanner sc = new Scanner(System.in);
//        List<List<Integer>> adj =  new ArrayList<>();
//        for(int i=0;i<=n;i++){
//            adj.add(new ArrayList<>());
//        }
// 		for(int i=0;i<m;i++){
// 		    int u = sc.nextInt();
// 		    int v = sc.nextInt();
// 		    adj.get(u).add(v);
// 		    adj.get(v).add(u);
// 		}
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//        adj.get(1).add(3);
//        adj.get(3).add(1);
//        adj.get(2).add(4);
//        adj.get(4).add(2);
//        adj.get(3).add(4);
//        adj.get(4).add(3);
//        int startNode = sc.nextInt();
//        for(int i=0;i<adj.size();i++){
//            System.out.println(i+ " " + adj.get(i));
//        }
//        bfs(n, startNode, adj);
//        dfs(n, startNode, adj);
        List<List<Edge>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Edge(1, 4));
        adj.get(1).add(new Edge(0, 4));

        adj.get(0).add(new Edge(2, 3));
        adj.get(2).add(new Edge(0, 3));

        adj.get(1).add(new Edge(2, 1));
        adj.get(2).add(new Edge(1, 1));

        adj.get(1).add(new Edge(3, 2));
        adj.get(3).add(new Edge(1, 2));

        adj.get(2).add(new Edge(3, 4));
        adj.get(3).add(new Edge(2, 4));
        findMST(n, adj);
    }
}
