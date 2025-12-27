/** Computes the binomial(n,k) function. */
/** Computes the binomial(n,k) function. */
public class Binomial {
    public static void main(String[] args) {
        if (args.length > 1) {
             System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        }
    }

    public static int binomial1(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || n == 0) return 1;
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
    }

    public static long binomial(int n, int k) {
     
        if (k > n) return 0;
        
        if (k == 0 || n == 0) return 1;
        
        long[][] memo = new long[n + 1][k + 1];
        
       
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
		return binomial(n, k, memo);
       
    }

    private static long binomial(int n, int k, long[][] memo) {
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        
        if (k > n) {
            memo[n][k] = 0;
            return 0;
        }
        if (n == 0 || k == 0) {
            memo[n][k] = 1;
            return 1;
        }
        
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}