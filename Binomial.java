/** Computes the binomial(n,k) function. */
public class Binomial {
    public static void main(String[] args) {
        // Uncomment the version of binomial that you want to test

        // Testing the basic binomial implementation:
        if (args.length > 1) {
             System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        }

        // Testing the optimized binomial implementation:
        if (args.length > 1) {
             System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        }
    }

    // Computes the Binomial function, basic version.
    public static int binomial1(int n, int k) {
        // Base case: if k > n, the result is 0 [cite: 38, 45]
        if (k > n) return 0;
        // Base case: if k is 0 or n is 0, the result is 1 [cite: 40, 47]
        if (k == 0 || n == 0) return 1;
        
        // Recursive step: Pascal's identity [cite: 43, 48]
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
    }

    // Computes the Binomial function, efficiently
    public static int binomial(int n, int k) {
        // This function creates a 2D array, say memo, 
        // and then initializes all its elements to -1.
        
        // Create the array with dimensions (n+1) x (k+1) to accommodate indices 0 to n and 0 to k
        int[][] memo = new int[n + 1][k + 1]; // [cite: 65]
        
        // Initialize all elements to -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1; // [cite: 65]
            }
        }
        
        // It then calls binomial(n, k, memo), which does all the heavy lifting.
        return binomial(n, k, memo); // [cite: 66]
    }

    private static int binomial(int n, int k, int[][] memo) {
        // If the value has already been computed, return it [cite: 68-69]
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        
        // Base case: if k > n, result is 0
        if (k > n) {
            memo[n][k] = 0;
            return 0;
        }
        
        // Another base case: if n == 0 or k == 0, result is 1
        if (n == 0 || k == 0) {
            memo[n][k] = 1;
            return 1;
        }
        
        // Recursive step with memoization: store the result before returning [cite: 70]
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}

