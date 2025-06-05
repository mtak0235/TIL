import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static char[][] graph;
    static List<Integer> values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                graph[i][j] = st.nextToken().charAt(0);
        }
        values = new ArrayList<>();
        //logic
        dfs(0, 0, graph[0][0] - '0', ' ');
        System.out.printf("%d %d", Collections.max(values) , Collections.min(values));
    }

    static int[] dx = { 1, 0 };
    static int[] dy = { 0, 1 };

    public static void dfs(int x, int y, int value, char op) {
        if (x == n - 1 && y == n - 1) {
            values.add(value);
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= n || ny >= n)
                continue;
            if (Character.isDigit(graph[nx][ny])) {
                int nextValue = calculate(value, graph[nx][ny] - '0', op);
                dfs(nx, ny, nextValue, ' ');
            } else
                dfs(nx, ny, value, graph[nx][ny]);
        }
    }

    static int calculate(int value, int newValue, char op) {
        switch (op) {
            case '+':
                return value + newValue;
            case '-':
                return value - newValue;
            case '*':
                return value * newValue;
        }
        return newValue;
    }
}