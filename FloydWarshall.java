import java.util.*;
public class FloydWarshall {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("no. of vertices");
        int V = input.nextInt();
        System.out.println("no. of edges");
        int E = input.nextInt();
        input.nextLine();
        Edge []edges = new Edge[E];
        TreeMap<String,Integer> vertices = new TreeMap<String,Integer>();
        for(int i=1;i<V+1;i++){
            System.out.println("name of vertix "+i);
            String x = input.nextLine();
            vertices.put(x,i);
            
        }
        int[][] dist = new int[V+1][V+1];
        String[][] pie = new String[V+1][V+1];
        
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    pie[i][j] = "N"; 
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2; 
                    pie[i][j] = "N";
                }
            }
        }

        for(int i=0;i<E;i++){
            System.out.println("give source ");
            String src = input.nextLine();
            System.out.println("give destination ");
            String des = input.nextLine();
            System.out.println("give weight ");
            int wt = input.nextInt();
            input.nextLine();
            edges[i] = new Edge(vertices.get(src),vertices.get(des),wt);
            dist[vertices.get(src)][vertices.get(des)] = wt;
            pie[vertices.get(src)][vertices.get(des)] = src;
        }


        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if ( dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pie[i][j] = pie[k][j];
                    }
                }
            }
            System.out.println();
        System.out.println("dist table");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("pie table");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print(pie[i][j] + " ");
            }
            System.out.println();
        }
        }   
        System.out.println();
        System.out.println("dist table");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("pie table");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print(pie[i][j] + " ");
            }
            System.out.println();
        }


    }
}
class Edge{
    int src,des;
    int weight;
    Edge(int src,int des,int weight){
        this.src = src;
        this.des = des;
        this.weight = weight;
    }
}
