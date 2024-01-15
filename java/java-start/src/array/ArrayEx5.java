package array;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요:");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println(length + "개의 정수를 입력하세요");
        int tot = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            tot += arr[i];
        }
        System.out.println("입력한 정수의 합계:" + tot);
        System.out.println("입력한 정수의 평균: " + ((double) tot / arr.length));
    }
}
