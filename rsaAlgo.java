import java.util.Scanner;

public class rsaAlgo {

    private static int expPowMod(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    private static int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1)
            return 0;
        while (a > 1) {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(" prime p: ");
        int p = input.nextInt();
        System.out.print(" prime q: ");
        int q = input.nextInt();
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        System.out.println("phi "+phi);
        System.out.print("public exponent e (1 < e < phi(n)) and coprime to phi(n): ");
        int e = input.nextInt();
        
        int d = modInverse(e, phi);
        System.out.println("Public Key (n, e): (" + n + ", " + e + ")");
        System.out.println("Private Key (n, d): (" + n + ", " + d + ")");
        System.out.print("message as integer (0 <= m < "+n+"): ");
        int m = input.nextInt();

        int ciphertext = expPowMod(m, e, n);
        System.out.println("Encrypted ciphertext: " + ciphertext);

        int decrypted = expPowMod(ciphertext, d, n);
        System.out.println("Decrypted message: " + decrypted);

        input.close();
    }
}
