package array;

import java.util.Scanner;

public class ArrayEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println(arr.length + "개의 정수를 입력하세요:");
        for (int i = 0; i < arr.length; i++) {
            int got = scanner.nextInt();
            arr[i] = got;
        }
        System.out.println("출력");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",\t");
            }
        }
    }
}