package project3;

public class project3 {
    public static void main (String[] args){
        System.out.println("yes");
        int[] p = {7,6,9};
        // int[] w = {4,6,8};
        int[] w = {3,6,8};
        int r1 = knapsack(w,p,14,3);
        int r = knapsackUnlimited(w,p,14,3);
        int r2 = knapsackRec(w, p, 14, 3);
        int r3 = knapsackRecUnlimited(w,p,14,3);
    }

    public static int knapsack(int[] w, int[] p, int C, int n){
        int[][] profit = new int[C+1][n+1];
        for (int i = 0;i<n;i++)
            profit[0][i] = 0;
        for (int i = 0;i<C;i++)
            profit[i][0] = 0;
        for (int r = 1; r <= C; r++){
            // r represent the capacity
            for (int c = 1; c <= n; c++){
                // c represent how many objects in knapsack
                // find in r capacity, how many objects we take will max the profit
                profit[r][c] = profit[r][c-1];
                if (w[c-1]<=r){
                    if (profit[r][c] < profit[r-w[c-1]][c-1] + p[c-1])
                        profit[r][c] = profit[r-w[c-1]][c-1] + p[c-1];
                }
            }
        } // O(nC)
        return profit[C][n];
    }

    public static int knapsackUnlimited(int[] w, int[] p, int C, int n){
        int[][] profit = new int[C+1][n+1];
        for (int i = 0;i<n;i++)
            profit[0][i] = 0;
        for (int i = 0;i<C;i++)
            profit[i][0] = 0;
        for (int r = 1; r <= C; r++){
            // r represent the capacity
            for (int c = 1; c <= n; c++){
                // c represent which object in knapsack
                // find in r capacity, how many objects we take will max the profit
                profit[r][c] = profit[r][c-1];                
                if (w[c-1]<=r){
                    // if (profit[r][c] < profit[r-w[c-1]][c] + p[c-1])
                    profit[r][c] = Math.max(profit[r][c-1], profit[r-w[c-1]][c] + p[c-1]);
                }
            }
        } // O(nC)
        return profit[C][n];
    }

    public static int knapsackRec(int[] w, int[] p, int C, int n){
        if (n<=0)
            return 0;
        else if (w[n-1] > C){
            return knapsackRec(w, p, C, n-1);
        }
        else{
            return Math.max(knapsackRec(w, p, C, n-1), p[n-1] + knapsackRec(w, p, C-w[n-1], n-1));
        }
        // O(2^n)
    }

    public static int knapsackRecUnlimited(int[] w, int[] p, int C, int n){
        if (n<=0)
            return 0;
        else if (w[n-1] > C){
            return knapsackRecUnlimited(w, p, C, n-1);
        }
        else{
            int m = Math.max(p[n-1] + knapsackRecUnlimited(w, p, C-w[n-1], n-1), p[n-1] + knapsackRecUnlimited(w, p, C-w[n-1], n));
            return Math.max(knapsackRecUnlimited(w, p, C, n-1), m);
        }
        // O(2^n)
    }
}
