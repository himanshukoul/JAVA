import java.util.*;
public class rabinkarp2{
  
    static void search(String txt, String pattern, int q) {
      int d = 10;
      int n = txt.length();
      int m = pattern.length();
      int p = 0;
      int t = 0;
      int h = 1;
  
      for (int i = 0; i < m - 1; i++) // can do directly also h = d^(m-1)%q but it reduces time for big no.s
        h = (h * d) % q;            //h = d ^ (m-1)   i.e. for pattern of length 5; (10^(5-1) % 13)
      //hash for patt and text
      for (int i = 0; i < m; i++) {
        p = (d * p + (pattern.charAt(i)-48)) % q;                //auto type casting
        t = (d * t + (txt.charAt(i)-48)) % q;
      }
      for (int i = 0; i <= n - m; i++) {
        if (p == t) {
                     //CROSSCHECK
            if (txt.substring(i,i+pattern.length()).equals(pattern)){ //i.e. correct match
                System.out.println("Valid hit index " + (i + 1));
              
            }
            else{  
                System.out.println("Spurious hit index " + (i + 1));
            }
          
        }
  
        if (i < n - m) {  //subtracting hash due to first char and adding hash of new char
          t = (d * (t - (txt.charAt(i)-48) * h) + (txt.charAt(i + m)-48)) % q;
          if (t < 0)
            t = (t + q);        //handling negative modulo
        }
      }
    }
  
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        String txt = input.nextLine();
        String pattern = input.nextLine();
        int q = input.nextInt();
        search(txt,pattern, q);
    }
  }

