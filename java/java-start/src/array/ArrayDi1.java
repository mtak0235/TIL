package array;

public class ArrayDi1 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] arr1 = {
                {1, 2, 3},
                {4, 5, 6}
        };


        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("=");

        for (int r = 0; r < arr1.length; r++) {
            for (int c = 0; c < arr1[0].length; c++) {
                System.out.print(arr1[r][c] + " ");
            }
            System.out.println();
        }
    }
}
