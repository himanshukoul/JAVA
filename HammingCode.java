import java.util.*;

public class HammingCode {
    private static String[] toBinaryStr(int x,int k){
        String res= "";
        int sum = 0;
        while(res.length()!=k){
            sum += x%2;
            res += Integer.toString(x%2);
            x /= 2;
        }
        String res2="";
        for(char c:res.toCharArray()){
            res2 = c + res2;
        }
        return new String[]{res2,Integer.toString(sum)};
        }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Number of rows ");
        int x = input.nextInt();
        System.out.println("Number of columns ");
        int y = input.nextInt();

        int Htrp[][] = new int[x][y];
        System.out.println("Give input for the H Transpose Matrix");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Htrp[i][j] = input.nextInt();
            }
        }

        int hmat[][] = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                hmat[i][j] = Htrp[j][i];
            }
        }
        int n = x;
        int q = y;
        int k = n-q;
        int [][] pt = new int[q][k];
        for(int i = 0;i<q;i++){
            for(int j=0;j<k;j++){
                pt[i][j] = hmat[i][j];
            }
        }
        /*int [][] p = new int[k][q];
        for(int i = 0;i<k;i++){
            for(int j=0;j<q;j++){
                p[i][j] = hmat[j][i];
            }
        }*/
        String temp;
        System.out.print(" ".repeat(k));
        for(int i=1;i<=q;i++){
            System.out.print("p"+i+" ");
        }
        System.out.println("H.D");
        int mx = (int)Math.pow(2,k);
        for(int i=0;i<mx;i++){
            String []temparr = toBinaryStr(i,k);
            temp = temparr[0];
            int ones = Integer.parseInt(temparr[1]);
            System.out.print(temp+" ");
            for(int j =0;j<q;j++){
                int par = 0;
                for(int l=0;l<k;l++){
                    par ^= ((int)(temp.charAt(l)-'0'))*(pt[j][l]);
                }
                ones += par;
                System.out.print(par+"  ");
            }
            System.out.println(ones);
        }
    }
}

