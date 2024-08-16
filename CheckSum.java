import java.util.*;
public class CheckSum {
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
    
    private static String binAdd(String a,String b){
        //System.out.println(a +" "+b);
        int abit,bbit;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i=3;i>=0;i--){
            abit = a.charAt(i) - '0';
            bbit = b.charAt(i)- '0';
            int sum = abit + bbit + carry;
            if(sum>=2) carry = 1;
            else carry = 0;
            res.insert(0, sum % 2);
        }
        if(carry==1){
            return binAdd("0001", res.toString());
        }
        return res.toString();
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter roll no");
        Map<Character,Integer> hm = new HashMap<>();
        Character [] arr = new Character[16];
        for(int i=0;i<16;i++){
            if(i<10){
                hm.put((char)(i+'0'),i);
                arr[i] = (char)(i+'0');
            }
            else{
                hm.put((char)( i-10+'A'),i);
                arr[i] = (char)( i-10+'A');
            }
        }
        String s = input.nextLine();
        int j=0;
        String [] sarr = new String[s.length()];
        for(char c: s.toCharArray()){
            String s1 = "";
            String sbs = toBinaryStr(hm.get(c));
            sarr[j] = sbs;
            j++;
        }
        String sum = sarr[0];
        for (int i = 1; i < sarr.length; i++) {
            sum = binAdd(sum, sarr[i]);
            System.out.println("Intermediate sum "+sum);
        }
        String fin = "";
        //complement
        for(int i=3;i>=0;i--){
            if(sum.charAt(i)=='0') fin = "1" + fin;
            else fin = "0" + fin;
        }
        System.out.println("Complemented checksum " +fin);
        int num=0;
        for(int i=0;i<4;i++){
            num += (int) Math.pow(2*(int)(fin.charAt(i)-'0'),3-i);
        }
        System.out.println("message sent: "+s+arr[num]);

    }
}

