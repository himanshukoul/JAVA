import java.util.*;

public class huffman {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        node[] obj = new node[n];
        int i;
        for (i = 0; i < n; i++) {
            input.nextLine();
            char cx = input.next().charAt(0);
            float freq = input.nextFloat();
            obj[i] = new node(cx, freq, null, null);
        }

        PriorityQueue<node> pq = new PriorityQueue<>(Arrays.asList(obj));   
        //order is maintained in ascending frequency due to comparator and compareTo 
        while (pq.size() > 1) {
            node left = pq.poll();
            node right = pq.poll();
            float newf = left.freq + right.freq;
            pq.add(new node(newf, left, right));
        }

        node finalobj = pq.poll();

        huffcode(finalobj, "");
    }

    static void huffcode(node root, String code) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                System.out.println(root.ch + " " + code);
            }
            huffcode(root.left, code + "0");
            huffcode(root.right, code + "1");
        }
    }
}

class node implements Comparable<node> {
    node left = null;
    node right = null;
    char ch;
    float freq;

    public node(char ch, float freq, node left, node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public node(float freq, node left, node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public int compareTo(node temp) {
        return Float.compare(this.freq, temp.freq);
    }
}

