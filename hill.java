import java.util.ArrayList;
import java.util.Scanner;

public class hill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter key matrix size ");
        int n = input.nextInt();
        int[][] key = new int[n][n];
        
        System.out.println("Enter key matrix values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                key[i][j] = input.nextInt();
            }
        }
        
        input.nextLine(); 
        System.out.println("Enter plaintext:");
        String plaintext = input.nextLine();
        
        while (plaintext.length() % n != 0) {
            plaintext += 'x';
        }
        
        StringBuilder ciphertext = new StringBuilder();
        ArrayList<String> ls = new ArrayList<>();
        
        for (int i = 0; i < plaintext.length(); i += n) {
            ls.add(plaintext.substring(i, i + n));
        }
        
        for (String s : ls) {
            for (int i = 0; i < n; i++) {
                int x = 0;
                for (int j = 0; j < n; j++) {
                    x += key[i][j] * (s.charAt(j) - 'a' + 1);
                }
                x--;
                x %= 26; 
                ciphertext.append((char) ('a' + x));
            }
        }
        
        System.out.println("Ciphertext: " + ciphertext.toString());
    }
}