import java.util.*;
public class MatrixMultp{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("no. of matrix:");
        int n = input.nextInt();
        int p[] = new int[n+1];
        for(int x = 0;x<n+1;x++){
            p[x] = input.nextInt();
        }
        int costab [][] = new int[n+1][n+1];
        int stab [][] = new int[n+1][n+1];
        int outp = mult(p,costab,stab,1,n);  //optimal soln. at 1,5 for 5 matrix
        System.out.println("optimal cost of computation: "+outp);
        System.out.println();
        for(int a=1;a<n+1;a++){
            for(int b = 1;b<n+1;b++){
                System.out.printf(costab[a][b]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int a=1;a<n+1;a++){
            for(int b = 1;b<n+1;b++){
                System.out.printf(stab[a][b]+" ");
            }
            System.out.println();
        }
    }
    static int mult(int[]p,int[][]costab,int [][] stab,int i, int j){
        if (i==j){
            costab[i][j] = 0;
            stab[i][j] = 0;
            return 0;
        }
        int lowest = Integer.MAX_VALUE;
        int kforStab = 0;
        for(int k=i;k<j;k++){
            int term = mult(p, costab, stab, i, k) + mult(p, costab, stab, k+1, j) + p[i-1]*p[k]*p[j];
            if(term < lowest){
                lowest = term;
                kforStab = k;
            }
        }
        costab[i][j] = lowest;
        stab[i][j] = kforStab;
        return lowest;
    }
}
