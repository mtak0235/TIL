package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("n개의 정수를 입력하세요 (종료 0)");
		List<Integer> list = new ArrayList<>();
		while (true) {
			int num = scanner.nextInt();
			if (num == 0) {
				break;
			}
			list.add(num);
		}
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i);
		}
		System.out.println("입력한 정수의 합계:" + total);
		System.out.println("입력한 정수의 평균:" + (double)total / list.size());

	}
}
