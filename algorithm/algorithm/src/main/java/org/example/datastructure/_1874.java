package org.example.datastructure;

import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        int num = 1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int su = a[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    stringBuffer.append("+\n");
                }
                stack.pop();
                stringBuffer.append("-\n");
            } else {
                int _n = stack.pop();
                if (_n > su) {
                    System.out.println("NO");
                    flag = false;
                    return;
                } else {
                    stringBuffer.append("-\n");
                }
            }
        }
        if (flag) {
            System.out.println(stringBuffer.toString());

        }
    }
}
