import java.util.Arrays; 

public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {

    }
    public static void main(String[] args) {
        FindDiagonalOrder diagonalOrder = new FindDiagonalOrder() ;
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[] orders = diagonalOrder.findDiagonalOrder(matrix) ; 
        System.out.println(Arrays.toString(orders)) ;
    }
}
