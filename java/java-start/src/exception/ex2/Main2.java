package exception.ex2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        NetworkServiceV1_1 networkService = new NetworkServiceV1_1();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자:");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            networkService.sendMessage(input);
        }
        System.out.println("terminating program");
    }
}
