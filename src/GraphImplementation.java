import java.util.*;

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
    public static void bfs(){
        int n = 4;
        int m = 4;
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
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
    }
    public static void dfs(){
        int n = 4;
        int m = 4;
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n+1];
        Stack<Integer> s = new Stack<>();
        s.push(0);
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
    }
    public static void main(String[] args) {
        dfs();
    }
}
