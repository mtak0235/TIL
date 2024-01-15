package array;

public class ArrayDi2 {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        int i = 1;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                arr[r][c] = i++;
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
    }
}
