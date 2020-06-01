package DynamicProgrammingSolutions;

import sparseMCP.SparseMCP;
import sparseMCP.Tuple;

import java.util.ArrayList;
import java.util.Arrays;



// The explanation how this dynamic programming works,
// is explained in the "Introduction to Algorithms, Second Edition by Thomas H.Cormen, Charles E. Leiserson
// or just check here  https://www.geeksforgeeks.org/java-program-for-matrix-chain-multiplication-dp-8/



public class Naiv_dynamic_MCP {


    public static int MatrixChainOrder(int[] p, int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int [][] m = new int[n][n];

        int i, j, k, L, q;

        /* m[i, j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix. if i=j costs = 0.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

    // Driver program to test above function
    public static void main(String [] args)
    {
        //6,2,1,5,8,9,12,3,8,7,10,4
        int [] arr = new int[] { 10,2,5,7,4}; //7, 10, 4
        int size = arr.length;

        long startTime = System.nanoTime();
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, size));
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");
    }
}