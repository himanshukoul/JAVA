import java.util.Arrays;

public class ColumnRow {
    public static String rowencrypt(String plaintext, int[] key) {
        int rows = key.length;
        int cols = (int) Math.ceil((double) plaintext.length() / rows);
        
        char[][] grid = new char[rows][cols];
        
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (k < plaintext.length()) {
                    grid[i][j] = plaintext.charAt(k++);
                } else {
                    grid[i][j] = ' ';
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int row : key) {
            int actualRow = row - 1;
            for (int col = 0; col < cols; col++) {
                ciphertext.append(grid[actualRow][col]);
            }
        }
        
        return ciphertext.toString();
    }
    public static String colencrypt(String plaintext, int[] key) {
        int cols = key.length;
        int rows = (int) Math.ceil((double) plaintext.length() / cols);
        
        char[][] grid = new char[rows][cols];
        
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (k < plaintext.length()) {
                    grid[i][j] = plaintext.charAt(k++);
                } else {
                    grid[i][j] = ' ';
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int col : key) {
            int actualCol = col - 1;
            for (int row = 0; row < rows; row++) {
                ciphertext.append(grid[row][actualCol]);
            }
        }
        
        return ciphertext.toString();
    }
    
    public static void main(String[] args) {
        String plaintext = "attackpostponeduntiltwoamxyz";
        int[] keycol = {3, 4, 2, 1, 5, 6, 7};
        System.out.println("Plaintext: " + plaintext);
        System.out.println("KEY: "+Arrays.toString(keycol));
        String ciphertextcol = colencrypt(plaintext, keycol);
        System.out.println("Column Ciphertext: " + ciphertextcol);

        int[] keyrow = {1,3,2,4};
        System.out.println("Plaintext: " + plaintext);
        System.out.println("KEY: "+Arrays.toString(keyrow));
        String ciphertextrow = rowencrypt(plaintext, keyrow);
        System.out.println("Row Ciphertext: " + ciphertextrow);
    }
}