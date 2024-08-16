import java.util.*;
public class LCS {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();
        String y = input.nextLine();
        int x_len = x.length();
        int y_len = y.length();
        int [][] costab = new int[x_len+1][y_len+1];
        char [][] symboltab = new char[x_len+1][y_len+1];
        for(int i = 0;i<x_len+1;i++){
            costab[i][0] = 0;
            symboltab[i][0] = '0';
        }
        for(int j = 0;j<y_len+1;j++){
            costab[0][j] = 0;
            symboltab[0][j] = '0';
        }
        for(int i = 1;i < x_len+1;i++){
            for(int j=1; j<y_len+1;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    costab[i][j] = costab[i-1][j-1] + 1;
                    symboltab[i][j] = '\\';
                }
                else if(costab[i-1][j]>=costab[i][j-1]){
                    costab[i][j] = costab[i-1][j];
                    symboltab[i][j] = '|';
                }
                else{
                    costab[i][j] = costab[i][j-1];
                    symboltab[i][j] = '-';
                }
            }
        }
        for(int i = 0;i < x_len+1;i++){
            for(int j=0; j<y_len+1;j++){
                System.out.print(costab[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0;i < x_len+1;i++){
            for(int j=0; j<y_len+1;j++){
                System.out.print(symboltab[i][j]+" ");
            }
            System.out.println();
        }
    
        System.out.printf("the longest common subsequence is: ");
        printlcs(symboltab,x,x_len,y_len);
        System.out.printf(" with length: %d",costab[x_len][y_len]);
    }
    static void printlcs(char[][] symboltab,String x,int i,int j){
        if (i==0 || j==0){
            return;
        }
        if (symboltab[i][j]=='\\'){
            printlcs(symboltab,x,i-1,j-1);
            System.out.printf("%c",x.charAt(i-1));
        }
        else if(symboltab[i][j]=='|'){
           printlcs(symboltab,x,i-1,j);
        }
        else{
           printlcs(symboltab,x,i,j-1);
        }
    }
}

