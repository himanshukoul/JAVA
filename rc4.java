import java.util.*;
import java.io.*;

public class rc4 {
    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        String path = "pt.txt";
        FileReader fr = new FileReader(path);
        int x;
        String pt = "";
        while (true) {
            x = fr.read();
            if (x == -1)
                break;
            pt += (char) x;
        }
        System.out.println("Plaintext "+pt);

        int[] s = new int[256];
        int[] t = new int[256];
        System.out.println("give key");
        String key = input.nextLine();
        int n = key.length();

        for (int i = 0; i < 256; i++) {
            s[i] = i;
            t[i] = (int) key.charAt(i % n);
        }
        System.out.println("S vec");
        for (int i = 0; i < 256; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println("\n T vec");
        for (int i = 0; i < 256; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + t[i]) % 256;
            s[i] = s[i] + s[j]; // swap
            s[j] = s[i] - s[j];
            s[i] = s[i] - s[j];
        }
        System.out.println("S after initialization");

        for (int i = 0; i < 256; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();

        int i = 0;
        j = 0;
        String cipher = "";
        for (int y = 0; y < pt.length(); y++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;
            s[i] = s[i] + s[j]; // swap
            s[j] = s[i] - s[j];
            s[i] = s[i] - s[j];
            int tx = (s[i] + s[j]) % 256;
            int kp = s[tx];
            cipher += (char) ((int) pt.charAt(y) ^ kp);
        }

        System.out.println("Cipher " +cipher);

        FileWriter fwrt = new FileWriter("enc.txt");
        fwrt.write(cipher);
        fwrt.close();
    }
}
