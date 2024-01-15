package org.example.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2164 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Queue<Integer> queue = new LinkedList<>();
    int n = scanner.nextInt();
    for (int i = 0; i <= n; i++) {
      queue.add(i);
    }
    while (queue.size() > 1) {
      queue.poll();
      queue.add(queue.poll());
    }
    System.out.println(queue.poll());

  }
}
