public class bellmanFord {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        //System.out.println("no. of vertices");
        int V = input.nextInt();
        //System.out.println("no. of edges");
        int E = input.nextInt();
        Graph graph = new Graph(V,E);
    }
}

class Edge {
    char src, dest;
    int weight;
    Edge(char src,char dest,int weight) { 
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V, E;
    char names[];
    int dist[];
    char pie[];
    int dist_matrx[][];
    char pie_matrx[][];
    Edge []edges;

    Graph(int v, int e)
    {   
        Scanner input = new Scanner(System.in);
        V = v;
        E = e;
        dist = new int[V];
        pie = new char[V];
        names = new char[V];
        dist_matrx = new int[V][V];  
        pie_matrx = new char[V][V];
        for(int i=0;i dist[nam.indexOf(edges[j].src)]+edges[j].weight){
                return false;
            }
        }
        return true;

    }
    
    void initialize(int source){
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            pie[i] = 'N';
        }
        dist[source] = 0;
        pie[source] = '0';
        dist_matrx[0] = Arrays.copyOf(dist, dist.length);
        pie_matrx[0] = Arrays.copyOf(pie, pie.length);
        
    }
    void relax(char src,char des,int wt){
        String nam = new String(names);
        if(dist[nam.indexOf(des)]>dist[nam.indexOf(src)]+wt){
            dist[nam.indexOf(des)] = dist[nam.indexOf(src)]+wt;
            pie[nam.indexOf(des)] = src;
        }
    }

}
