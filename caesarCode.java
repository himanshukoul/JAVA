import java.util.Scanner;

public class caesarCode{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("plain text");
        String plaintext = input.nextLine();
        System.out.println("key");
        int key = input.nextInt();
        String ciphertext ="";
        for(int i = 0; i < plaintext.length(); i++){
            char c = plaintext.charAt(i);
            ciphertext += (char) (((int)(c-'a') + key)%26 + 'A');
        }
        System.out.println(ciphertext);
        
    }
}