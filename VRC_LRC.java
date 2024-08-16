import java.util.*;
public class VRC_LRC {
    private static String toBinaryStr(int x){
        String res= "";
        while(res.length()!=4){
            res += Integer.toString(x%2);
            x /= 2;
        }
        String res2="";
        for(char c:res.toCharArray()){
            res2 = c + res2;
        }
        return res2;
        }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter roll no");
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<16;i++){
            if(i<10){
                hm.put((char)(i+'0'),i);
            }
            else{
                hm.put((char)( i-10+'A'),i);
            }
        }
        String s = input.nextLine();
        int [] arr = new int[4];
        int j=0;
        for(char c: s.toCharArray()){
            String s1 = "";
            s = toBinaryStr(hm.get(c));
            //System.out.println(s);
            int onesforvrc = 0;
            for(int k =0;k<4;k++){
                arr[k] = (int)(s.charAt(k) -'0')+ arr[k];
                onesforvrc += (int)(s.charAt(k) -'0');
            }
            System.out.print(c+" "+s+" "+ onesforvrc%2);
            System.out.println();
        }
        System.out.print("  ");
        for(int k =0;k<4;k++){
            System.out.print(arr[k]%2);
        }
        System.out.println();
        }       
}



