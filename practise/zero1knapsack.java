public class zero1knapsack {
    public static void main(String[] args) {
        int capacity  = 20 ;
        int weights[] = {1,2,3,5,6};
        int profit[] = {2,3,4,5,6};
        int n = weights.length;

        System.out.println("Maximum profit in 01 knapsack: " + knapsack01(n,weights,profit,capacity));
    }

    static int knapsack01(int n,int[] weights , int[] profit , int capacity){
        int[][] V = new int[n+1][capacity+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= capacity ; j++){
                if(i == 0 || j == 0){
                    V[i][j] = 0;
                } else if(weights[i-1] <= j){
                    V[i][j] = Math.max(V[i-1][j] , V[i-1][j-weights[i-1]] + profit[i-1]);
                }else{
                    V[i][j] = V[i-1][j];
                }
            }
        }

        return V[n][capacity];
    }
}
