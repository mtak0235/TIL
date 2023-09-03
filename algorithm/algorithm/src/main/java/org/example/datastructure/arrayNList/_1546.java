package org.example.datastructure.arrayNList;

import java.util.Scanner;

public class _1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[] A = new int[n];
//        for (int i = 0; i < n; i++) {
//            A[i] = scanner.nextInt();
//        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            if (tmp >max) max = tmp;
            sum += tmp;
//            if (A[i]> max) max = A[i];
//            sum += A[i];
        }
        System.out.println(sum * 100. / max / n);
    }
}
