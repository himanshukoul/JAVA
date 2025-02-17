package COMPETIT;

import java.util.*;

public class SegmentTreeTemp {
    static class SGTree {
        int[] sg;
        int n;

        SGTree(int n) {
            this.n = n;
            this.sg = new int[4 * n + 1];
        }

        private void build(int index, int l, int r, int arr[]) {
            if (l == r) {
                sg[index] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(2 * index + 1, l, mid, arr);
            build(2 * index + 2, mid + 1, r, arr);
            sg[index] = Math.min(sg[2 * index + 1], sg[2 * index + 2]);
        }

        private int query(int index, int l, int r, int ql, int qr) {
            if (l > qr || r < ql)
                return Integer.MAX_VALUE;
            if (ql <= l && qr >= r)
                return sg[index];
            int mid = (l + r) / 2;
            int left = query(2 * index + 1, l, mid, ql, qr);
            int right = query(2 * index + 2, mid + 1, r, ql, qr);
            return Math.min(left, right);
        }

        private void update(int index, int l, int r, int i, int val) {
            if (l == r) {
                sg[index] = val;
                return;
            }
            int mid = (l + r) / 2;
            if (i <= mid)
                update(2 * index + 1, l, mid, i, val);
            else
                update(2 * index + 2, mid + 1, r, i, val);
            sg[index] = Math.min(sg[2 * index + 1], sg[2 * index + 2]);
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int totaltrees = input.nextInt();
        SGTree sgm[] = new SGTree[totaltrees];
        for (int i = 0; i < totaltrees; i++) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = input.nextInt();
            }
            sgm[i] = new SGTree(n);
            sgm[i].build(0, 0, n - 1, arr);
            System.out.println("Segment Tree " + i);
            for (int k = 0; k < 4 * n + 1; k++) {
                System.out.print(sgm[i].sg[k] + " ");
            }
            System.out.println();
        }
        // total operations
        int t = input.nextInt();
        while (t-- > 0) {
            // 1: Update segment tree , 2:Query
            int choice = input.nextInt();
            //
            if (choice == 1) {
                // tree 0,or 1 or 2...
                int tree = input.nextInt();
                // arr index and value to update
                int p = input.nextInt();
                int val = input.nextInt();
                sgm[tree].update(0, 0, sgm[tree].n - 1, p, val);
                System.out.println("Updated Segment tree " + tree);
                for (int k = 0; k < 4 * sgm[tree].n + 1; k++) {
                    System.out.print(sgm[tree].sg[k] + " ");
                }
                System.out.println();
            } else {
                int minm = Integer.MAX_VALUE;
                for (int i = 0; i < totaltrees; i++) {
                    // different ranges to find minm in all arr's
                    int l = input.nextInt();
                    int r = input.nextInt();
                    minm = Math.min(minm, sgm[i].query(0, 0, sgm[i].n - 1, l, r));
                }
                System.out.println("minimum across all arrays in their ranges : " + minm);
            }
        }
    }
}
