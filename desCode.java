import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class desCode {
    private static int IP[] = new int[] {
            58, 50, 42, 34, 26, 18, 10, 2,
            60, 52, 44, 36, 28, 20, 12, 4,
            62, 54, 46, 38, 30, 22, 14, 6,
            64, 56, 48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17, 9, 1,
            59, 51, 43, 35, 27, 19, 11, 3,
            61, 53, 45, 37, 29, 21, 13, 5,
            63, 55, 47, 39, 31, 23, 15, 7
    };
    private static int E[] = new int[] {
            32, 1, 2, 3, 4, 5,
            4, 5, 6, 7, 8, 9,
            8, 9, 10, 11, 12, 13,
            12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29,
            28, 29, 30, 31, 32, 1
    };

    private static int P[] = new int[] {
            16, 7, 20, 21,
            29, 12, 28, 17,
            1, 15, 23, 26,
            5, 18, 31, 10,
            2, 8, 24, 14,
            32, 27, 3, 9,
            19, 13, 30, 6,
            22, 11, 4, 25
    };

    private static int FP[] = new int[] {
            40, 8, 48, 16, 56, 24, 64, 32,
            39, 7, 47, 15, 55, 23, 63, 31,
            38, 6, 46, 14, 54, 22, 62, 30,
            37, 5, 45, 13, 53, 21, 61, 29,
            36, 4, 44, 12, 52, 20, 60, 28,
            35, 3, 43, 11, 51, 19, 59, 27,
            34, 2, 42, 10, 50, 18, 58, 26,
            33, 1, 41, 9, 49, 17, 57, 25
    };

    private static int S[][][] = new int[][][] {
            {
                    { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
                    { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                    { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 }
            },
            {
                    { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
                    { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
                    { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
                    { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 }
            },
            {
                    { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                    { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                    { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                    { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 }
            },
            {
                    { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
                    { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                    { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                    { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 }
            },
            {
                    { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                    { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                    { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                    { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 }
            },
            {
                    { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                    { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                    { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                    { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 }
            },
            {
                    { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                    { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                    { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                    { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 }
            },
            {
                    { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                    { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
                    { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
                    { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 }
            }
    };

    private static int PC1[] = new int[] {
            57, 49, 41, 33, 25, 17, 9,
            1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29,
            21, 13, 5, 28, 20, 12, 4
    };

    private static int PC2[] = new int[] {
            14, 17, 11, 24, 1, 5,
            3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8,
            16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32
    };

    private static int SHIFTS[] = new int[] { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

    public static String toBin(int x, int rep) {
        String r = "";
        while (r.length() != rep) {
            r = (char) x % 2 + r;
            x /= 2;
        }
        return r;
    }

    public static String xoring(String e, String r) {
        String res = "";
        for (int i = 0; i < e.length(); i++) {
            res += e.charAt(i) == r.charAt(i) ? '0' : '1';
        }
        return res;
    }

    public static String func(String r, String k) {
        String e = "";
        for (int x : E) {
            e += r.charAt(x - 1);
        }
        // System.out.println("e "+ e);
        // int eOfr = Integer.parseInt(e, 2);
        String xored = xoring(e, k);
        String res = "";
        int t = 0;
        for (int i = 0; i < 48; i += 6) {
            String bi = xored.substring(i, i + 6);
            res += toBin(S[t++][Integer.parseInt(bi.charAt(0) + "" + bi.charAt(5), 2)][Integer
                    .parseInt(bi.substring(1, 5), 2)], 4);
        }
        String p = "";
        for (int x : P) {
            p += res.charAt(x - 1);
        }
        // System.out.println(p);
        return p;
    }

    public static String encrypt(String key, String message, Map<Character, Integer> hm, Map<Integer, Character> hm2) {
        String keybin = convertToBinary(key, hm, 4);
        String mesbin = convertToBinary(message, hm, 4);

        String[] keysbin = generateKeySchedule(keybin);
        System.out.println("Subkeys ");
        for (String kx : keysbin) {
            System.out.println(kx);
        }
        String ip = performInitialPermutation(mesbin);

        String[] L = new String[17];
        String[] R = new String[17];
        L[0] = ip.substring(0, ip.length() / 2);
        R[0] = ip.substring(ip.length() / 2, ip.length());

        for (int i = 1; i < 17; i++) {
            L[i] = R[i - 1];
            String ff = func(R[i - 1], keysbin[i]);
            R[i] = xoring(L[i - 1], ff);
        }

        String fnl = R[16] + L[16];
        String encr = performFinalPermutation(fnl);

        return convertBinaryToHex(encr, hm2);
    }

    public static String decrypt(String key, String encryptedMessage, Map<Character, Integer> hm,
            Map<Integer, Character> hm2) {
        String keybin = convertToBinary(key, hm, 4);
        String mesbin = convertToBinary(encryptedMessage, hm, 4);

        String[] keysbin = generateKeySchedule(keybin);

        String ip = performInitialPermutation(mesbin);

        String[] L = new String[17];
        String[] R = new String[17];
        L[0] = ip.substring(0, ip.length() / 2);
        R[0] = ip.substring(ip.length() / 2, ip.length());

        for (int i = 1; i < 17; i++) {
            L[i] = R[i - 1];
            String ff = func(R[i - 1], keysbin[17 - i]);
            R[i] = xoring(L[i - 1], ff);
        }

        String fnl = R[16] + L[16];
        String decr = performFinalPermutation(fnl);

        return convertBinaryToHex(decr, hm2);
    }

    private static String convertToBinary(String text, Map<Character, Integer> hm, int binaryLength) {
        String binary = "";
        for (char c : text.toCharArray()) {
            binary += toBin(hm.get(c), binaryLength);
        }
        return binary;
    }

    private static String[] generateKeySchedule(String keybin) {
        String kplus = "";
        for (int i = 0; i < PC1.length; i++) {
            kplus += keybin.charAt(PC1[i] - 1);
        }

        String[] C = new String[17];
        String[] D = new String[17];
        C[0] = kplus.substring(0, kplus.length() / 2);
        D[0] = kplus.substring(kplus.length() / 2, kplus.length());

        for (int i = 1; i < 17; i++) {
            char[] temp = new char[28];
            int shf = SHIFTS[i - 1];
            for (int j = 0; j < 28; j++) {
                temp[j] = C[i - 1].charAt((j + shf) % 28);
            }
            C[i] = new String(temp);

            for (int j = 0; j < 28; j++) {
                temp[j] = D[i - 1].charAt((j + shf) % 28);
            }
            D[i] = new String(temp);
        }

        String[] keysbin = new String[17];
        for (int i = 0; i < 17; i++) {
            keysbin[i] = "";
            String t = C[i] + D[i];
            for (int j = 0; j < PC2.length; j++) {
                keysbin[i] += t.charAt(PC2[j] - 1);
            }
        }

        return keysbin;
    }

    private static String performInitialPermutation(String input) {
        String ip = "";
        for (int i : IP) {
            ip += input.charAt(i - 1);
        }
        return ip;
    }

    private static String performFinalPermutation(String input) {
        String fp = "";
        for (int i : FP) {
            fp += input.charAt(i - 1);
        }
        return fp;
    }

    private static String convertBinaryToHex(String binary, Map<Integer, Character> hm2) {
        String hexString = "";
        for (int i = 0; i < 64; i += 4) {
            hexString += hm2.get(Integer.parseInt(binary.substring(i, i + 4), 2));
        }
        return hexString;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<Character, Integer> hm = new HashMap<>();
        Map<Integer, Character> hm2 = new HashMap<>();
        for (char c = '0'; c <= '9'; c++) {
            hm.put(c, (int) (c - '0'));
            hm2.put((int) (c - '0'), c);
        }
        for (char c = 'A'; c <= 'F'; c++) {
            hm.put(c, (int) (c - 'A' + 10));
            hm2.put((int) (c - 'A' + 10), c);
        }

        System.out.println("key");
        String key = input.nextLine();
        System.out.println("message");
        String message = input.nextLine();

        String encrypted = encrypt(key, message, hm, hm2);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("give encrypted code to decrpyt");
        String encryptedinput = input.nextLine();
        String decrypted = decrypt(key, encryptedinput, hm, hm2);
        System.out.println("Decrypted: " + decrypted);
    }
}
// himanshu koul
// K = 133457799BBCDFF1 , m = 0123456789ABCDEF