import java.io.*;
import java.util.*;

public class StandardInput {
	public static void main(String[] args) {
		useScanner();

	}
	
	public static void useScanner() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
	}
	public static void useBufferedReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
	}
}
