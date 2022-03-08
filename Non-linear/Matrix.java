import java.util.Arrays;

public class Matrix {

    private final int[][] matrix;
    private int m, n;
    private final boolean isSquare;


    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
        this.isSquare = m == n;

        // Initialize the Matrix with 0's
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = 0;
            }
        }
    }


    public Matrix(int [] [] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;     // rows
        this.n = matrix[0].length;  // cols

        try {
            // check number of cols of each row
            for (int row = 1; row < m; row++) {
                if (n != matrix[row].length) {
                    throw new Exception("Matrix Dimensions does not match: Error at row " + row);
                }
            }
        }
        catch (Exception er) {
            er.printStackTrace();
        }
        this.isSquare = m == n;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[\n").append("\t");

        for (int[] i : this.matrix) {
            str.append(Arrays.toString(i)).append('\n').append("\t");
        }

        str.append("\b]");
        return str.toString();
    }

    // Identity matrix is n x n with 1's on main diagonal and 0's everywhere else
    public static Matrix I(int n) {
        Matrix eye = new Matrix(n, n);

        for (int row = 0; row < n; row++) {
            eye.matrix[row][row] = 1;
        }

        return eye;
    }


    // sum of all values on the main diagonal
    public int trace() {
        int result = 0;
        for (int row = 0; row < m; row++) {
            result += this.matrix[row][row];
        }
        return result;
    }


    public int det() {
        try {
            if (isSquare) {

                // if it's 2 x 2 matrix
                if (m == 2) {
                    return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
                }

                // if it's n x n
                else {

                }

            } else {
                throw new Exception("Matrix must be square n x n");
            }
        } catch (Exception er) {
            er.printStackTrace();
        }

        return 0;
    }

    public void inverse() {
        try {

            int determinant = this.det();

            if (determinant == 0) {
                throw new Exception("No Inverse Exists");
            } else {

                // at this point the matrix is square
                if (n == 2) {
                    int temp = matrix[0][0];
                    matrix[0][0] = matrix[1][1];
                    matrix[0][1] *= -1;
                    matrix[1][0] *= -1;
                    matrix[1][1] = temp;
                }

            }

            // 2 x 2
            // 1 / det (A) * [d -b, -c a]

            // n * n
            // 1 / det(A) * adj(A) -> Cofactor(A)^T


            // or

            // [A | I] apply REF


        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int [] [] m = {
                {1, 2},
                {1, 2}
        };

        Matrix m2 = new Matrix(m);
        System.out.println(m2);
    }

}
