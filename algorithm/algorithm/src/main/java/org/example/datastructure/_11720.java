package org.example.datastructure;

import java.util.Scanner;

/**
 * 문제 분석하기 -> 손으로 풀어보기 -> 수도 코드 작성하기
 */
public class _11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();
        int ret = 0;
        for (int i = 0; i < cNum.length; i++) {
            ret += cNum[i] - '0';
        }
        System.out.println(ret);
    }
}
