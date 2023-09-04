package org.example.datastructure.arrayNList;

import java.util.Scanner;

public class _2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 1;
        int sum = 1;
        int start_idx = 1;
        int end_idx = 1;
        while (end_idx != n) {
            if (sum == n) {
                count++;
                end_idx ++;
                sum += end_idx;
            } else if (sum > n) {
                sum -= start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum += end_idx;
            }
        }
        System.out.println(count);
    }
}
