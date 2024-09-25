import java.util.*;
public class KMP {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String Text = input.nextLine();
        String Pattern = input.nextLine();
        KMP_matcher(Text, Pattern);
    }
    public static void KMP_matcher(String T,String P){
        int n = T.length();
        int m = P.length();
        int []pie = new int[m];
        pie = prefix_fn(P);
        System.out.println("pie table");
        for(int i = 0;i<pie.length;i++){
            System.out.printf("%d ",pie[i]);
        }
        System.out.println();
        int q = 0;
        for(int i=0;i<n;i++){
            while (q>0 && P.charAt(q) != T.charAt(i) ) {
                q = pie[q-1];
            }
            if(P.charAt(q)==T.charAt(i)){
                q= q+1;
            }
            if (q==m){
                System.out.printf("Given pattern  %s is found in T with s= %d ",P,(i-m+1));
                q = pie[q-1];
            }
        }
    }
    public static int[] prefix_fn(String P){
        int m = P.length();
        int pie[] = new int[m];
        pie[0] = 0;
        int k = 0;   //len of prev. longest pref suffx
        for(int q=1;q<m;q++){
            while(k>0 && P.charAt(k)!= P.charAt(q)){
                k = pie[k-1];
            }
            if(P.charAt(k)==P.charAt(q)){
                k=k+1;
            }
            pie[q] = k;
        }
        return pie;
    }
}
