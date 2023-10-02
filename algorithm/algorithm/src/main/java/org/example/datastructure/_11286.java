package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a1, a2) -> {
            //절대값 작은 데이터 우선
            int first_abs = Math.abs(a1);
            int second_abs = Math.abs(a2);
            //절대값이 작은 경우 음수 우선
            if (first_abs == second_abs) {
                return a1 > a2 ? 1 : -1;
            }
            return first_abs - second_abs; //음수일떄 swap
        });
        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(bufferedReader.readLine());
            if (request == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(request);
            }
        }

    }
}
