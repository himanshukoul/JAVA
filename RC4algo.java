import java.util.*;

public class RC4algo {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("keylen");
        int keylen = input.nextInt();
        int key[] = new int[keylen];
        int plaintext[] = new int[1000];
        for (int i = 0; i < keylen; i++) {
            key[i] = input.nextInt();
        }
        int S[] = new int[256];
        int T[] = new int[256];
        for (int i = 0; i < 256; i++) {
            S[i] = i;
            T[i] = key[i % keylen];
        }
        System.out.println("S vec");
        for (int i = 0; i < 256; i++) {
            System.out.print(S[i] + " ");
        }
        System.out.println("\n T vec");
        for (int i = 0; i < 256; i++) {
            System.out.print(T[i] + " ");
        }
        System.out.println();

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + T[i]) % 256;
            // swap
            S[i] = S[i] ^ S[j];
            S[j] = S[i] ^ S[j];
            S[i] = S[i] ^ S[j];
        }
        System.out.println("S after initialization");

        for (int i = 0; i < 256; i++) {
            System.out.print(S[i] + " ");
        }

        int i = 0;
        j = 0;
        int check = 0;
        String cipherText = "";
        int x = 0;
        input.nextLine();
        System.out.println();
        while (true) {
            String s = input.nextLine();
            check = Integer.parseInt(s);
            if (check == -1)
                break;
            plaintext[x] = check;
            i = (i + 1) % 256;
            j = (j + S[i]) % 256;
            // swap
            S[i] = S[i] ^ S[j];
            S[j] = S[i] ^ S[j];
            S[i] = S[i] ^ S[j];
            int t = (S[i] + S[j]) % 256;
            int k = S[t];
            cipherText += k ^ plaintext[x++];
            cipherText += " ";
        }
        System.out.println("cipher text" + cipherText);

    }
}
