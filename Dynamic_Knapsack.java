import java.util.*;
public class Dynamic_Knapsack {
    public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("Knapsack capacity");
    int W = input.nextInt();
    System.out.println("no. of items");
    int n = input.nextInt();
    int [] weight = new int[n];
    int [] value = new int[n];
    for(int i = 0;i<n;i++){
        System.out.println("weight");
        weight[i] = input.nextInt();
        System.out.println("value");
        value[i] = input.nextInt();
    }
    int [][] costab = new int[n+1][W+1];
    for(int j=0;j<W+1;j++){
        costab[0][j]= 0z;
    }
    for(int i=0;i<n+1;i++){
        costab[i][0]= 0;
    }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<W+1;j++){
            if(j-weight[i-1]>=0){
                if((value[i-1]+costab[i-1][j-weight[i-1]]) >= costab[i-1][j]){
                    costab[i][j]= value[i-1] + costab[i-1][j-weight[i-1]];
                }
                else{
                    costab[i][j] = costab[i-1][j];
                }
            }
            else{
                costab[i][j] = costab[i-1][j];
            }
        }
    }
    for(int i = 0;i<n+1;i++){
        for(int j =0;j<W+1;j++){
            System.out.print(costab[i][j]+" ");
        }
        System.out.println();
    }
}
}

