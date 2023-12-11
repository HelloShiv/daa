import java.util.LinkedList;
class Graph{
    int V;
    java.util.LinkedList<Integer> adj[];

    Graph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V ; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void printVertexCover(){
        boolean[] visited = new boolean[V];
        for(int u = 0 ; u < V ; u++){
            if(!visited[u]){
                for(int v : adj[u]){
                    if(!visited[v]){
                        visited[u] = true;
                        visited[v] = true;
                        break;
                    }
                }
            }
        }

        for(int i = 0 ; i < V ;i++){
            if(visited[i]){
                System.out.print( " " + i);
            }
        }
        System.out.println();
    }
}
public class vertex {
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        g.printVertexCover();
    }
}
