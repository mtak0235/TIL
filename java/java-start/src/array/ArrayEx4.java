package array;

import java.util.Scanner;

public class ArrayEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println(arr.length + "개의 정수를 입력하세요");
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        System.out.println("입력한 정수의 합계:\t" + total);
        System.out.println("입력한 정수의 평균:\t" + ((double) total / arr.length));
    }
}
